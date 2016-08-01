package com.ted.service;

import com.ted.model.User;

public interface LoginService {
	
	User saveUser(User user);

	String checkEmailUsernameAfm(User user);

}
