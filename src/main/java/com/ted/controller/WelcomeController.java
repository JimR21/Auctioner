package com.ted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/home")
	public String sayHello(Model model) {
		
		System.out.println("Inside WelcomeController");
		
		model.addAttribute("greeting", "hello world");
		
		return "home";
	}
}
