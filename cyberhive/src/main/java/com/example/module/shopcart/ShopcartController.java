package com.example.module.shopcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopcartController {
	
	@Autowired
	ShopcartService shopcartService;
	
	@RequestMapping(value = "/user/shopcart/ShopcartUserForm")
	public String shopcartUserForm() {
		
		return "user/shopcart/ShopcartUserForm";
	}
}
