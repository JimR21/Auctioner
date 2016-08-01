package com.ted.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ted.model.Customer;
import com.ted.model.User;
import com.ted.service.UserService;

@Controller
@RequestMapping(value = "/api")
public class XMLController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="user/{username}", method = RequestMethod.GET)
	public @ResponseBody User getUserInXML(@PathVariable String username) {

		User user = userService.getUserByUsername(username);
		
		System.out.println("User in controller: " + user.getUsername());
		
		return user;

	}
	
	@RequestMapping(value = "user/new", method = RequestMethod.PUT) 
	public String newUser(@RequestBody User user, Model model) {
		
		System.out.println("User: " + user.getUsername());
		
		return "200 OK";

	} 
	
	@RequestMapping(value="customer/get", method = RequestMethod.GET)
	public @ResponseBody Customer getUserInXML() {

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("Sumeet");
		customer.setAge(22);
		
		
		return customer;

	}
	
	@RequestMapping(value = "customer/put", method = RequestMethod.PUT) 
	public @ResponseBody String newCustomer(@RequestBody Customer customer, Model model) {
		
		System.out.println("Customer: " + customer.getName());
		
		return "200 OK";

	} 

}


