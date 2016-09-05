package com.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.Authority;
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
	
	public boolean isUserBidder() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    for(GrantedAuthority auth : authentication.getAuthorities())
		    {
		    	if(auth.getAuthority().equals("ROLE_BIDDER"))
		    		return true;
		    }
		}
		
		return false;
	}
	
	public boolean isUserSeller() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    for(GrantedAuthority auth : authentication.getAuthorities())
		    {
		    	if(auth.getAuthority().equals("ROLE_SELLER"))
		    		return true;
		    }
		}
		
		return false;
	}
	
	public boolean isUserAdmin() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    for(GrantedAuthority auth : authentication.getAuthorities())
		    {
		    	if(auth.getAuthority().equals("ROLE_ADMIN"))
		    		return true;
		    }
		}
		
		return false;
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

	public User getUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
		
	}

	@Transactional
	public boolean hasAuthority(String username, String role) {
		
		User user = userRepository.findByUsername(username);
		
		List<Authority> authorities = user.getAuthorities();
		
		for(Authority authority : authorities) {
			if(authority.getId().getRole().equals(role))
				return true;
		}
		
		return false;
	}

	public User getUserById(int id) {

		return userRepository.findByUserid(id);
		
	}
	
}
