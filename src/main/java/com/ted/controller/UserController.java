package com.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ted.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String getMyProfile(Model model) {
		
		return "myprofile";
		
	}
	
	@RequestMapping(value = "/upgrade", method = RequestMethod.GET)
	public String getUpgrade(Model model) {
		
		return "upgrade";
	}

}
