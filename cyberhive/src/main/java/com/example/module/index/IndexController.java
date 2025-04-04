package com.example.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	IndexService indexService;
	
	@RequestMapping(value = "/xdm/codeGroup/indexXdmForm")
	public String indexXdmList(Model model) throws Exception{
		
		return "xdm/index/IndexXdmForm";
	}
	
}
