package com.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ted.model.Message;
import com.ted.model.User;
import com.ted.service.MessageService;
import com.ted.service.UserService;

@Controller
@RequestMapping(value = "/messaging")
public class MessageController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageService messageService;

	@RequestMapping(value = "inbox", method = RequestMethod.GET)
	public String userInbox(Model model) {
		
		User user = userService.getLoggedInUser();
		
		model.addAttribute("inbox", messageService.getByReceiver(user));
		
		return "user-inbox";
		
	}
	
	@RequestMapping(value = "sent", method = RequestMethod.GET)
	public String userSent(Model model) {
		
		User user = userService.getLoggedInUser();
		
		model.addAttribute("sent", messageService.getBySender(user));
		
		return "user-sent";
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String userMessage(@PathVariable Integer id, Model model) {
		
		User user = userService.getLoggedInUser();
		Message message = messageService.getById(id);
		
		if(messageService.isMessageOwner(user.getUsername(), message)) {
			
			model.addAttribute("message", message);
			
			return "message";
		}
		
		return "redirect:myprofile";
		
	}
	
	@RequestMapping(value = "/isRead/{id}", method = RequestMethod.GET)
	public @ResponseBody String userMessageIsRead(@PathVariable Integer id, Model model) {
		
		User user = userService.getLoggedInUser();
		Message message = messageService.getById(id);
		
		if(messageService.isMessageOwner(user.getUsername(), message)) {
			
			messageService.messageIsRead(message);
	
			return "200 OK";
		}
		
		return "Error";
		
	}
	
	@RequestMapping(value = "new-message", method = RequestMethod.GET)
	public String userNewMessageGet(Model model) {
		
		Message message = new Message();
		
		model.addAttribute("new_message", message);
		
		return "new-message";
		
	}
	
	@RequestMapping(value = "new-message", method = RequestMethod.POST)
	public String userNewMessagePost(@ModelAttribute("message") Message message, Model model) {
		
		System.out.println("Receipient: " + message.getReceiver().getUsername());
		System.out.println("Message:" + message.getMessage());
		
		return "user-sent";
		
	}
}
