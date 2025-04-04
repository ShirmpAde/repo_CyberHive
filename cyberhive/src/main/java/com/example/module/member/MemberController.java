package com.example.module.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/xdm/member/memberXdmList")
	public String memberXdmList(Model model, MemberVo vo) throws Exception{
		vo.setParamsPaging(memberService.seletOneCount());
		
		model.addAttribute("list", memberService.selectList(vo));
		
		model.addAttribute("vo", vo);
		System.out.println("vo.getShDateStart(): " + vo.getShDateStart());
		System.out.println("vo.getShDateEnd(): " + vo.getShDateEnd());
		System.out.println("vo.getShOptionDate(): " + vo.getShOptionDate());
		System.out.println("vo.getShOption(): " + vo.getShOption());
		System.out.println("vo.getShValue(): " + vo.getShValue());
		
		return "xdm/member/MemberXdmList";
	}
	
	@RequestMapping(value = "/xdm/member/memberXdmView")
	public String memberXdmList(Model model, MemberDto memberDto) {
		System.out.println("memberDto.getSeq(): " + memberDto.getSeq());
		model.addAttribute("item", memberService.selectOne(memberDto));
		return "xdm/member/memberXdmView";
	}
	
	@RequestMapping(value = "/xdm/member/memberXdmForm")
	public String memberXdmForm() {
		
		return "xdm/member/memberXdmForm";
	}
	
	@RequestMapping(value = "/xdm/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {
		System.out.println("memberDto.getSeq(): " + memberDto.getSeq());
		System.out.println("memberDto.getName(): " + memberDto.getName());

		memberService.insert(memberDto);

		System.out.println("memberDto.getSeq(): " + memberDto.getSeq());

		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/xdm/member/memberXdmMfom")
	public String memberXdmMfom(MemberDto memberDto, Model model) {
		
		model.addAttribute("item", memberService.selectOne(memberDto));
		
		return "xdm/member/memberXdmMfom";
	}
	
	@RequestMapping(value = "/xdm/member/memberXdmUpdt")
	public String memberXdmUpdt(MemberDto memberDto) {
		
		memberService.update(memberDto);
		
		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/xdm/member/memberXdmDele")
	public String memberXdmDele(MemberDto memberDto) {
		
		memberService.delete(memberDto);
		
		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/xdm/member/memberXdmUele")
	public String memberXdmUele(MemberDto memberDto) {
		
		memberService.uelete(memberDto);
		
		return "redirect:xdm/member/memberXdmList";
	}
	
	@RequestMapping(value = "/xdm/member/signinXdmForm")
	public String signinXdmForm(MemberVo vo, HttpSession httpSession) throws Exception {
		return "xdm/member/SigninXdmForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/xdm/member/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto memberDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		MemberDto rt = memberService.signinChk(memberDto);
		if (rt != null) {
			returnMap.put("rt", "success");
			httpSession.setMaxInactiveInterval(60 * 30); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rt.getSeq());
			httpSession.setAttribute("sessIdXdm", rt.getId());
			httpSession.setAttribute("sessNameXdm", rt.getName());
		} else {
			returnMap.put("rt", "fail");										
		}
		
		return returnMap;
	}
	
//	@RequestMapping(value = "/xdm/member/signoutXdmForm")
//	public String signoutXdmForm() {
//		
//		return "xdm/member/SignoutXdmForm";
//	}
	
	@ResponseBody
	@RequestMapping(value = "/xdm/member/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "/xdm/member/signupXdmForm")
	public String signupXdmForm(MemberVo vo, HttpSession httpSession) throws Exception {
	    return "xdm/member/signupXdmForm";
	}
}
