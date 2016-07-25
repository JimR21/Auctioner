package com.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ted.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		
		model.addAttribute("users", userService.getAllUsers());
		
		return "admin";
	}
}
