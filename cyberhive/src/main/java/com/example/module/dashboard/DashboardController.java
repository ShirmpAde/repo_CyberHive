package com.example.module.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
		
	@Autowired
	DashboardService dashboardService;
	
	@RequestMapping(value = "/xdm/index/dashboardXdmForm")
	public String dashboardXdmForm() {
		
		return "xdm/index/DashboardXdmForm";
	}
}
