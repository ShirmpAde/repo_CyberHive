package com.example.module.member;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.base.BaseController;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Controller
public class MemberController extends BaseController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MailService mailService;
	
	@Value("${kakaoJavaKey}") // application.properties에서 키 값 주입
    private String kakaoAppKey;
	
	@RequestMapping(value = "/member/memberXdmList")
	public String memberXdmList(MemberVo vo, MemberDto dto, Model model) {
		utildatetime(vo);
		
		vo.setParamsPaging(memberService.selectOneCount(vo));
		
		model.addAttribute("list", memberService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/member/MemberXdmList";
	}
	
	@RequestMapping(value = "/member/signinXdmForm")
	public String signinXdmForm(MemberVo vo, HttpSession httpSession) {		
		return "xdm/member/SigninXdmForm";
	}
	
	@RequestMapping(value = "/member/memberXdmForm")
	public String memberXdmForm() {
		
		return "xdm/member/memberXdmForm";
	}
	
	@RequestMapping(value = "/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {
		System.out.println("memberDto.getSeq(): " + memberDto.getMembSeq());
		System.out.println("memberDto.getName(): " + memberDto.getName());
		
		memberService.insert(memberDto);

		System.out.println("memberDto.getSeq(): " + memberDto.getMembSeq());

		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/member/memberXdmMfom")
	public String memberXdmMfom(MemberDto memberDto, Model model) {
		
		model.addAttribute("item", memberService.selectOne(memberDto));
		
		return "xdm/member/memberXdmMfom";
	}
	
	@RequestMapping(value = "/member/memberXdmUpdt")
	public String memberXdmUpdt(MemberDto memberDto) {
		
		memberService.update(memberDto);
		
		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/member/memberXdmDele")
	public String memberXdmDele(MemberDto memberDto) {
		
		memberService.delete(memberDto);
		
		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/member/memberXdmUele")
	public String memberXdmUele(MemberDto memberDto) {
		
		memberService.uelete(memberDto);
		
		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/member/membersXdmExcel")
	public void exportMembersToCsv(HttpServletResponse response,MemberVo vo) throws Exception {
		vo.setParamsPaging(memberService.selectOneCount(vo));
	    List<MemberDto> members = memberService.selectList(vo);

	    response.setContentType("text/xls; charset=UTF-8");
	    response.setHeader("Content-Disposition", "attachment; filename = members.xls");
	   
	    PrintWriter writer = response.getWriter();
	    writer.println("번호,작성자,카테고리,제목,등록일,수정일");

	    for (MemberDto member : members) {
	        writer.printf("%s,%s,%s,%s,%s,%s\n",
	        	member.getMembSeq(),
	        	member.getSurName(),
	        	member.getName(),
	        	member.getId(),
	        	member.getMembRegDate(),
	        	member.getMembModDate()
	        );
	    }
	    writer.flush();
	    writer.close();
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = memberService.selectOneLogin(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
			httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rtMember.getMembSeq());
			httpSession.setAttribute("sessIdXdm", rtMember.getId());
			httpSession.setAttribute("sessNameXdm", rtMember.getName());
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "/member/signupXdmForm")
	public String signupXdmForm(MemberVo vo, HttpSession httpSession) throws Exception {
		
	    return "xdm/member/signupXdmForm";
	}
	
	@RequestMapping(value = "/user/index/indexUserForm")
	public String indexUserForm(Model model, MemberVo vo) throws Exception{
		
		model.addAttribute("list", memberService.selectList(vo));
		
		model.addAttribute("vo", vo);
		
		return "user/index/IndexUserForm";
	}
	
	@RequestMapping(value = "/user/index/signinUserForm")
	public String signinUserForm(MemberVo vo, HttpSession httpSession) throws Exception {
		return "user/index/SigninUserForm";
	}
	
	@RequestMapping(value = "/user/index/signupUserForm")
	public String signupUserForm(MemberVo vo, HttpSession httpSession) throws Exception {
		return "user/index/SignupUserForm";
	}
	
	
	@PostMapping(value = "/user/index/signupUserInst")
	public String memberInsert(MemberDto memberDto, Model model) {
		memberDto.setAuthLevel(1); // 일반 사용자
		
	    // 평문 비밀번호를 가져옴
	    String rawPassword = memberDto.getPassword();

	    // 암호화 (strength는 보통 10 정도)
	    String encryptedPassword = encodeBcrypt(rawPassword, 10);
	    memberDto.setPassword(encryptedPassword);

	    // 서비스 또는 DAO 호출
	    memberService.insert(memberDto);
	    
	    Thread thread = new Thread(new Runnable() {
	    
	    	@Override
	    	public void run() {
		 // 회원가입 축하 메일 전송
		    try {
		        mailService.sendMailWelcome(memberDto);
		    } catch (Exception e) {
		        e.printStackTrace();  // 예외 로그 출력
	    	};
    	}
    });
	    
	    thread.start();
	    
	    return "redirect:/user/index/indexUserForm";
	}
	
	@RequestMapping(value = "/user/index/LoginUserForm")
	public String shopcartUserForm() {
		
		return "user/index/LoginUserForm";
	}
	
	@RestController
	@RequestMapping("/xdm/member")
	public class MemberApiController {
		
	    @Autowired
	    private MemberService memberService;
	    
	    @PostMapping("/ConfirmId")
	    public ResponseEntity<?> confirmId(@RequestBody MemberDto memberDto) {
	        try {
	            System.out.println("🔔 요청 전체 내용: " + memberDto); // 추가 로깅
	            String id = memberDto.getId(); // 올바른 getter 메서드 사용
	            System.out.println("🔔 추출된 ID: " + id);
	            
	            if (id == null) throw new IllegalArgumentException("ID 파라미터 누락");
	            
	            boolean isAvailable = !memberService.isIdDuplicate(id);
	            return ResponseEntity.ok(isAvailable);
	        } catch (Exception e) {
	            e.printStackTrace(); // ★ 스택 트레이스 전체 출력
	            return ResponseEntity.internalServerError().body(e.getMessage());
	        }
	    }
    }
	
}
