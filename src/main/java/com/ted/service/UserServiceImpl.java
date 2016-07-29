package com.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.User;
import com.ted.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public User getLoggedInUser() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String username = authentication.getName();
		    return userRepository.findByUsername(username);
		}
		
		return null;
	}

	public List<User> getAllUsers() {
		
		return userRepository.findAll();
		
	}

	@Transactional
	public void approveUsers(List<String> approved) {
		
		User user;
		
		for(String username : approved) {
			user = userRepository.findByUsername(username);
			user.setApproved((byte)1);
			userRepository.save(user);
		}
	}
	
}
