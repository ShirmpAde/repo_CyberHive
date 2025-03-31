package com.example.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.module.code.CodeVo;

@Controller
//@RequestMapping(value = "/codeGroupXdmList")
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
		
		model.addAttribute("list", codeGroupService.selectList(vo));
		
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
	
//	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmForm")
//	public String codeGroupXdmForm() {
//
//		return "xdm/codeGroup/codeGroupXdmForm";
//	}
	
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
	
	@RequestMapping(value = "/xdm/codeGroupXdmForm/codeGroupXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		model.addAttribute("listCodeGroup", codeGroupService.selectListWithoutPaging(null));
		
		if (vo.getDelNy().equals("0") || vo.getDelNy().equals("")) {
			//	insert
		} else {
			model.addAttribute("item", codeGroupService.selectOne(vo));
		}
		return "xdm/codeGroupXdm/codeGroupXdmForm";
	}
	
	@RequestMapping(value = "/xdm/codeGroup/codeGroupXdmForm")
	public String codeGroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		
		if (vo.getSeq().equals("0") || vo.getSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(vo));
		}
		return "xdm/codeGroup/codeGroupXdmForm";
	}
}
