package com.alfalahsoftech.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceI adminService;
	
	@GetMapping("/admins")
	public String retrieveAdmin(Model model) {
		System.out.println("admins retrieval \n: " + adminService.findAll());
		model.addAttribute("admins",adminService.findAll().iterator().hasNext()?"Admin avaialble":"Admin Data not avaialble");
		
		return "adminHome";
	}
}
