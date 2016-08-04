package com.ted.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.Authority;
import com.ted.model.AuthorityPK;
import com.ted.model.User;
import com.ted.repository.AuthorityRepository;
import com.ted.repository.UserRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;

	@Transactional
	public User saveUser(User user) {
		
		// Enabled = true 
		user.setEnabled((byte)1);
		
		// BCrypt password encryption
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String hashedPass = passEncoder.encode(user.getPassword());
		user.setPassword(hashedPass);
		
		// Approved = false until admin checks it
		user.setApproved((byte)0);
		
		// User Rating
		user.setBidderRating(null);
		user.setSellerRating(null);
		
		// Persist user
		user = userRepository.saveAndFlush(user);
		
		// Authority Role
		AuthorityPK authorityPK = new AuthorityPK();
		authorityPK.setUserid(user.getUserid());
		authorityPK.setRole("ROLE_BIDDER");
		
		Authority authority = new Authority();
		authority.setId(authorityPK);
		authority.setUser(user);
		
		// Persist authority
		authorityRepository.saveAndFlush(authority);
		
		return user;
	}

	public String checkEmailUsernameAfm(User user) {
		
		if(userRepository.findByEmail(user.getEmail()) != null )
			return "Email already in use";
		if(userRepository.findByUsername(user.getUsername()) != null )
			return "Username already in use";
		if(userRepository.findByAfm(user.getAfm()) != null )
			return "AFM already in use";
		
		return null;
	}

}
