package com.ted.service;

import java.util.List;

import com.ted.model.User;

public interface UserService {
	
	User getLoggedInUser();
	
	List<User> getAllUsers();
	
	void approveUsers(List<String> approved);

}
