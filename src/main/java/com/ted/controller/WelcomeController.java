package com.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ted.model.User;
import com.ted.service.UserService;



@Controller
public class WelcomeController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value={"/", "home"})
	public String sayHello(Model model) {
	
//		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println("Currently logged in user is: " + activeUser.getUsername());
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    String name = auth.getName(); //get logged in username
	    
		User user = userService.getLoggedInUser();
		
		if(user != null)
			model.addAttribute("name", user.getUsername());
	     
		return "index";
	}
}
