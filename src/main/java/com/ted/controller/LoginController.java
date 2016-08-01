package com.ted.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ted.model.User;
import com.ted.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login (Model model) {
		System.out.println("Inside login controller");
		return "login";
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginFailed(Model model) {
		
		System.out.println("Login failed");
		
		model.addAttribute("error","Login failed. Please provide correct credentials." );
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "logout";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationGet(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrationPost(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("User password: " + user.getPassword());
		
		if(result.hasErrors()) {
			return "registration";
		}
		
		String msg = loginService.checkEmailUsernameAfm(user);
		if(msg != null)	// Check if email already exists
		{
			model.addAttribute("msg", msg);
			return "registration";
		}
		
		loginService.saveUser(user);
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error403(Model model) {
		return "403";
	}
}
