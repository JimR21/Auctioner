package com.ted.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ted.service.AuctionService;
import com.ted.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	AuctionService auctionService;


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdmin(Model model) {

		return "admin";
	}

	@RequestMapping(value = "/admin-inbox", method = RequestMethod.GET)
	public String getAdminInbox(Model model) {

		model.addAttribute("button", "inbox_tab");

		return "admin";
	}

	@RequestMapping(value = "/admin-new-message", method = RequestMethod.GET)
	public String getAdminNewMessage(Model model) {

		model.addAttribute("button", "newMessage_tab");

		return "admin";
	}

	@RequestMapping(value = "/admin-new-message/{receiver}", method = RequestMethod.GET)
	public String getAdminNewMessageReply(Model model, @PathVariable(value="receiver") String receiver) {

		System.out.println("Receiver: " + receiver);

		model.addAttribute("button", "newMessage_tab");
		model.addAttribute("receiver", receiver);

		return "admin";
	}

	@RequestMapping(value = "/admin-sent", method = RequestMethod.GET)
	public String getAdminSent(Model model) {

		model.addAttribute("button", "sent_tab");

		return "admin";
	}

	@RequestMapping(value = "/admin-anouncements", method = RequestMethod.GET)
	public String getAdminAnouncements(Model model) {

		model.addAttribute("button", "anouncements_tab");

		return "admin";
	}

	@RequestMapping(value = "/admin-users", method = RequestMethod.GET)
	public String getAdminUsers(Model model) {

		model.addAttribute("button", "users_tab");

		return "admin";
	}

	@RequestMapping(value = "/admin-auctions", method = RequestMethod.GET)
	public String getAdminAuctions(Model model) {

		model.addAttribute("button", "auctions_tab");

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

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String adminUsers(Model model) {

		/* Users */
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("userIdToDelete");

		return "admin_users";

	}

	@RequestMapping(value = "/admin/auctions", method = RequestMethod.GET)
	public String adminAuctions(Model model) {

		/* Auctions */
		model.addAttribute("auctions", auctionService.getAllAuctions());

		return "admin_auctions";

	}

}
