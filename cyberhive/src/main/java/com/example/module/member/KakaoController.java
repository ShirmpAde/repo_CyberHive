package com.example.module.member;

// import java.util.Map; // Map 대신 DTO 사용
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/kakao")
public class KakaoController {

    private static final Logger logger = LoggerFactory.getLogger(KakaoController.class);

    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Value("${kakao.client-secret}")
    private String clientSecret; // 카카오 앱 설정에서 Client Secret을 사용하는 경우

    private final RestTemplate restTemplate = new RestTemplate();

    // Step 1: 로그인 요청 시 카카오 로그인 페이지로 리다이렉트
    @GetMapping("/login")
    public String kakaoLoginRedirect() {
        String kakaoAuthUrl = "https://kauth.kakao.com/oauth/authorize?response_type=code"
                + "&client_id=" + clientId
                + "&redirect_uri=" + redirectUri;
        // + "&scope=profile_nickname,profile_image,account_email"; // 필요한 동의 항목 명시 (선택)
        logger.info("Redirecting to Kakao Auth URL: {}", kakaoAuthUrl);
        return "redirect:" + kakaoAuthUrl;
    }

    // Step 2: 카카오 로그인 후, redirect URI로 넘어온 code 처리
    @GetMapping("/callback")
    public String kakaoCallback(@RequestParam("code") String code, Model model) {
        try {
            // Step 3: 토큰 요청
            String tokenUrl = "https://kauth.kakao.com/oauth/token";

            HttpHeaders tokenHeaders = new HttpHeaders();
            tokenHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            // 카카오 문서에 따르면 Content-type: application/x-www-form-urlencoded;charset=utf-8 로 권장

            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type", "authorization_code");
            params.add("client_id", clientId);
            params.add("redirect_uri", redirectUri);
            params.add("code", code);
            if (clientSecret != null && !clientSecret.isEmpty()) { // clientSecret이 설정된 경우에만 추가
                 params.add("client_secret", clientSecret);
            }

            HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(params, tokenHeaders);
            
            logger.debug("Requesting token with params: {}", params);
            ResponseEntity<KakaoTokenResponseDto> tokenResponse = restTemplate.exchange(
                    tokenUrl, HttpMethod.POST, tokenRequest, KakaoTokenResponseDto.class);

            KakaoTokenResponseDto tokenDto = tokenResponse.getBody();
            if (tokenDto == null || tokenDto.getAccessToken() == null) {
                logger.error("Failed to retrieve access token from Kakao.");
                model.addAttribute("error", "카카오 인증 토큰을 받는데 실패했습니다.");
                return "errorPage"; // 에러 페이지로 리다이렉트 또는 에러 메시지 표시
            }
            String accessToken = tokenDto.getAccessToken();
            logger.info("Access Token: {}", accessToken);

            // Step 4: 사용자 정보 요청
            HttpHeaders userInfoHeaders = new HttpHeaders();
            userInfoHeaders.set("Authorization", "Bearer " + accessToken);
            userInfoHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED); // 카카오 v2 사용자 정보 요청시 권장

            HttpEntity<?> userInfoRequest = new HttpEntity<>(userInfoHeaders);

            ResponseEntity<KakaoUserResponseDto> userInfoResponse = restTemplate.exchange(
                    "https://kapi.kakao.com/v2/user/me",
                    HttpMethod.POST, // 카카오 v2 사용자 정보 가져오기는 POST도 지원하며, GET보다 POST 권장
                    userInfoRequest,
                    KakaoUserResponseDto.class
            );
            
            KakaoUserResponseDto kakaoUser = userInfoResponse.getBody();
            if (kakaoUser == null) {
                logger.error("Failed to retrieve user info from Kakao.");
                model.addAttribute("error", "카카오 사용자 정보를 가져오는데 실패했습니다.");
                return "errorPage";
            }

            Long kakaoId = kakaoUser.getId();
            String email = null;
            String nickname = null;

            if (kakaoUser.getKakaoAccount() != null) {
                email = kakaoUser.getKakaoAccount().getEmail();
                if (kakaoUser.getKakaoAccount().getProfile() != null) {
                    nickname = kakaoUser.getKakaoAccount().getProfile().getNickname();
                }
            }
            
            // 만약 properties 에서 닉네임을 가져오려면:
            // nickname = kakaoUser.getProperties() != null ? kakaoUser.getProperties().get("nickname") : null;


            logger.info("Kakao User ID: {}", kakaoId);
            logger.info("Kakao User Email: {}", email);
            logger.info("Kakao User Nickname: {}", nickname);

            // 여기서 KakaoDto를 사용한다면:
            KakaoDto appUserDto = new KakaoDto(String.valueOf(kakaoId), email, nickname);

            // Step 5: 회원가입 또는 로그인 처리
            // MemberService memberService = new MemberService(memberRepository); // 실제로는 @Autowired로 주입
            // Member member = memberService.processKakaoUser(appUserDto);
            // 세션 처리 등...

            model.addAttribute("kakaoId", kakaoId); // 또는 appUserDto.getId()
            model.addAttribute("email", email);     // 또는 appUserDto.getEmail()
            model.addAttribute("nickname", nickname); // 또는 appUserDto.getNickname()
            
            return "/user/index/LoginUserForm"; // 로그인 성공 후 보여줄 페이지

        } catch (HttpClientErrorException e) {
            logger.error("Kakao API Error: {} - {}", e.getStatusCode(), e.getResponseBodyAsString(), e);
            model.addAttribute("error", "카카오 API 요청 중 오류가 발생했습니다: " + e.getMessage());
            return "errorPage"; // 에러 페이지
        } catch (Exception e) {
            logger.error("An unexpected error occurred during Kakao callback processing.", e);
            model.addAttribute("error", "카카오 로그인 처리 중 알 수 없는 오류가 발생했습니다.");
            return "errorPage";
        }
    }
}