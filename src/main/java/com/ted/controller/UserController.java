package com.ted.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ted.model.User;
import com.ted.service.LoginService;
import com.ted.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String getMyProfile(Model model) {
		
		User user = userService.getLoggedInUser();
		
		if(user == null)
			return "index";
		
		model.addAttribute("user", user);
		
		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile/update", method = RequestMethod.GET)
	public String getMyProfileUpdate(Model model) {
		
		User user = userService.getLoggedInUser();
		
		if(user == null)
			return "index";
		
		model.addAttribute("user", user);
		
		return "update-profile";
	}
	
	@RequestMapping(value = "/myprofile/update", method = RequestMethod.POST)
	public String postMyProfileUpdate(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			@RequestParam(value = "input1", required=false) MultipartFile image) {
		
		if(result.hasErrors()) {
			return "update-profile";
		}
		
//		String msg = loginService.checkEmailUsername(user);
//		if(msg != null)	// Check if email already exists
//		{
//			model.addAttribute("msg", msg);
//			return "update-profile";
//		}
		
		loginService.updateUser(user, image);
		
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
	
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String getProfile(Model model, @PathVariable Integer id) {
		
		User usr = userService.getUserById(id);
		
		model.addAttribute("usr", usr);
		
		return "profile";
	}
	
	@RequestMapping(value = "/rating/bidder/{id}", method = RequestMethod.GET)
	public @ResponseBody Float getBidderRating(Model model, @PathVariable Integer id) {
		
		User usr = userService.getUserById(id);
		
		return usr.getBidderRating();
	}
	
	@RequestMapping(value = "/rating/seller/{id}", method = RequestMethod.GET)
	public @ResponseBody Float getSellerRating(Model model, @PathVariable Integer id) {
		
		User usr = userService.getUserById(id);
		
		return usr.getSellerRating();
	}
	
	@RequestMapping(value = "/rate/seller/{id}", method = RequestMethod.POST)
	public @ResponseBody String rateSeller(Model model, @PathVariable Integer id, @RequestParam("rating") Float rating) {
		
		userService.rateSeller(id, rating);
		
		return "200";
	}

}
