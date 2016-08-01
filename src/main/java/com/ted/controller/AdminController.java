package com.ted.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ted.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		
		model.addAttribute("users", userService.getAllUsers());
		
		model.addAttribute("userIdToDelete");
		
		return "admin";
	}
	
	@RequestMapping(value = "/approveUsers", method = RequestMethod.POST)
	public @ResponseBody String approve(@RequestParam(value="names[]") List<String> approved) {
		
		System.out.println("approved size: " + approved.size());
		
		for(String id : approved)
			System.out.println("User id: " + id + " is approved!");
		
		userService.approveUsers(approved);
		
		return "200 OK";
		
	}
}
