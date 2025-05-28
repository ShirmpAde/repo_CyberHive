package com.example.module.member;

import java.util.Map;

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
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/kakao")
public class KakaoController {
	
	@Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Value("${kakao.client-secret}") 
    private String clientSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    // Step 1: 로그인 요청 시 카카오 로그인 페이지로 리다이렉트
    @GetMapping("/login")
    public String kakaoLoginRedirect() {
        String kakaoAuthUrl = "https://kauth.kakao.com/oauth/authorize?response_type=code"
                + "&client_id=" + clientId
                + "&redirect_uri=" + redirectUri;
        return "redirect:" + kakaoAuthUrl;
    }

    // Step 2: 카카오 로그인 후, redirect URI로 넘어온 code 처리
    @GetMapping("/callback")
    public String kakaoCallback(@RequestParam("code") String code, Model model) {

        // Step 3: 토큰 요청
        String tokenUrl = "https://kauth.kakao.com/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);
        params.add("client_secret", clientSecret); // 선택사항

        HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(params, headers);

        ResponseEntity<Map> tokenResponse = restTemplate.exchange(tokenUrl, HttpMethod.POST, tokenRequest, Map.class);
        String accessToken = (String) tokenResponse.getBody().get("access_token");

        // Step 4: 사용자 정보 요청
        HttpHeaders userInfoHeaders = new HttpHeaders();
        userInfoHeaders.set("Authorization", "Bearer " + accessToken);

        HttpEntity<?> userInfoRequest = new HttpEntity<>(userInfoHeaders);

        ResponseEntity<Map> userInfoResponse = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.GET,
                userInfoRequest,
                Map.class
        );

        Map userInfo = userInfoResponse.getBody();
        String email = ((Map)((Map)userInfo.get("kakao_account"))).get("email").toString();
        String nickname = ((Map)userInfo.get("properties")).get("nickname").toString();

        // Step 5: 회원가입 또는 로그인 처리
        // (DB 확인 후 신규이면 회원가입, 기존이면 로그인 처리)

        model.addAttribute("email", email);
        model.addAttribute("nickname", nickname);
        return "user/welcome"; // 로그인 성공 후 보여줄 페이지
    }
}