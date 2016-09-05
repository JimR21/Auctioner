package com.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ted.model.User;
import com.ted.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String getMyProfile(Model model) {
		
		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile-inbox", method = RequestMethod.GET)
	public String getMyProfileInbox(Model model) {
		
		model.addAttribute("button", "inbox_tab");
		
		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile-new-message", method = RequestMethod.GET)
	public String getMyProfileNewMessage(Model model) {
		
		model.addAttribute("button", "newMessage_tab");
	
		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile-new-message/{receiver}", method = RequestMethod.GET)
	public String getMyProfileNewMessageReply(Model model, @PathVariable(value="receiver") String receiver) {
		
		System.out.println("Receiver: " + receiver);
		
		model.addAttribute("button", "newMessage_tab");
		model.addAttribute("receiver", receiver);
	
		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile-sent", method = RequestMethod.GET)
	public String getMyProfileSent(Model model) {
		
		model.addAttribute("button", "sent_tab");
	
		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile-anouncements", method = RequestMethod.GET)
	public String getMyProfileAnouncements(Model model) {
		
		model.addAttribute("button", "anouncements_tab");
	
		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile-settings", method = RequestMethod.GET)
	public String getMyProfileSettings(Model model) {
		
		model.addAttribute("button", "settings_tab");
	
		return "myprofile";
	}
	
	@RequestMapping(value = "/upgrade", method = RequestMethod.GET)
	public String getUpgrade(Model model) {
		
		return "upgrade";
	}
	
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String getProfile(Model model, @PathVariable Integer id) {
		
		User usr = userService.getUserById(id);
		
		model.addAttribute("usr", usr);
		
		return "profile";
	}

}
