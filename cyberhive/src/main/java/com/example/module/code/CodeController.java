package com.example.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/xdm/code/codeXdmList")
	public String codeXdmList(Model model, CodeVo vo) throws Exception{
		
		vo.setParamsPaging(codeService.seletOneCount());
		
		model.addAttribute("list", codeService.selectList(vo));
		
		model.addAttribute("vo", vo);
		
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/xdm/code/codeXdmView")
	public String codeXdmList(Model model, CodeDto codeDto) {
		System.out.println("codeDto.getSeq(): " + codeDto.getSeq());
		model.addAttribute("item", codeService.selectOne(codeDto));
		return "xdm/code/codeXdmView";
	}
	
//	@RequestMapping(value = "/xdm/code/codeXdmForm")
//	public String codeXdmForm() {
//		
//		return "xdm/code/codeXdmForm";
//	}
	
	@RequestMapping(value = "/xdm/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		System.out.println("codeDto.getSeq(): " + codeDto.getSeq());
		System.out.println("codeDto.getName(): " + codeDto.getName());

		codeService.insert(codeDto);

		System.out.println("codeDto.getSeq(): " + codeDto.getSeq());

		return "redirect:xdm/code/codeXdmList";
	}
	
	@RequestMapping(value = "/xdm/code/codeXdmMfom")
	public String codeXdmMfom(CodeDto codeDto, Model model) {
		
		model.addAttribute("item", codeService.selectOne(codeDto));
		
		return "xdm/code/codeXdmMfom";
	}
	
	@RequestMapping(value = "/xdm/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		
		codeService.update(codeDto);
		
		return "redirect:xdm/code/codeXdmList";
	}
	
	@RequestMapping(value = "/xdm/code/codeXdmDele")
	public String codeXdmDele(CodeDto codeDto) {
		
		codeService.delete(codeDto);
		
		return "redirect:xdm/code/codeXdmList";
	}
	
	@RequestMapping(value = "/xdm/code/codeXdmUele")
	public String codeXdmUele(CodeDto codeDto) {
		
		codeService.uelete(codeDto);
		
		return "redirect:xdm/code/codeXdmList";
	}
}


