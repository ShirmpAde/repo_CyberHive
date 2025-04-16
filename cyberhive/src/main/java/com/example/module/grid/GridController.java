package com.example.module.grid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GridController {
	
	@Autowired
	GridService gridService;
	
	@RequestMapping(value = "/user/grid/GridUserForm")
	public String gridUserForm() {
		
		return "user/grid/GridUserForm";
	}
}
