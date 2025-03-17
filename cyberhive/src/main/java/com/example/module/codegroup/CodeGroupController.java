package com.example.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
//	@Autowired
//	CodeGroupService service;
//	
//	@Autowired
//	CodeService codeService;
	
	@Autowired
	CodeGroupService codeGroupService;

	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmList")
	public String codeGroupXdmList(Model model, CodeGroupVo vo) throws Exception{
		
		vo.setParamsPaging(codeGroupService.seletOneCount());
		
		model.addAttribute("list", codeGroupService.selectList());
		
		model.addAttribute("vo", vo);
		
		return "xdm/codegroup/CodeGroupXdmList";
	}
	
//	@RequestMapping(value = "/codeGroup/codeGroupXdmList")
//	public String codeGroupXdmList(Model model) {
//		model.addAttribute("list", codeGroupService.selectList());
//		return "xdm/codegroup/CodeGroupXdmList";
//	}
	
	@RequestMapping(value = "/codeGroup/codeGroupXdmView")
	public String codeGroupXdmList(Model model, CodeGroupDto codeGroupDto) {
		System.out.println("codeGroupDto.getSeq(): " + codeGroupDto.getSeq());
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		return "xdm/codeGroup/codeGroupXdmView";
	}
	
	@RequestMapping(value = "/codeGroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		
		return "codeGroup/codeGroupXdmForm";
	}
	
	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		System.out.println("codeGroupDto.getSeq(): " + codeGroupDto.getSeq());
		System.out.println("codeGroupDto.getName(): " + codeGroupDto.getName());

		codeGroupService.insert(codeGroupDto);

		System.out.println("codeGroupDto.getSeq(): " + codeGroupDto.getSeq());

		return "redirect:/xdm/codeGroup/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmMfom")
	public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
		
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		
		return "xdm/codeGroup/codeGroupXdmMfom";
	}
	
	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmUpdt")
	public String codeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
		
		codeGroupService.update(codeGroupDto);
		
		return "redirect:/xdm/codeGroup/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmDele")
	public String codeGroupXdmDele(CodeGroupDto codeGroupDto) {
		
		codeGroupService.delete(codeGroupDto);
		
		return "redirect:/xdm/codeGroup/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmUele")
	public String codeGroupXdmUele(CodeGroupDto codeGroupDto) {
		
		codeGroupService.uelete(codeGroupDto);
		
		return "redirect:/xdm/codeGroup/codeGroupXdmList";
	}
}
