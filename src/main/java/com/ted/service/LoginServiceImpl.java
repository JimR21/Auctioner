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
	public User save(User user) {
		
		// Enabled = true 
		user.setEnabled((byte)1);
		
		// BCrypt password encryption
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String hashedPass = passEncoder.encode(user.getPassword());
		user.setPassword(hashedPass);
		
		// Approved = false until admin checks it
		user.setApproved((byte)0);
		
		// Persist user
		user = userRepository.saveAndFlush(user);
		
		
		AuthorityPK authorityPK = new AuthorityPK();
		authorityPK.setUserid(user.getUserid());
		authorityPK.setRole("ROLE_USER");
		
		Authority authority = new Authority();
		authority.setId(authorityPK);
		authority.setUser(user);
		
		// Persist authority
		authorityRepository.saveAndFlush(authority);
		
		return user;
	}

	public boolean checkEmail(User user) {
		
		if(!userRepository.findByEmail(user.getEmail()).isEmpty())
			return true;
		
		return false;
	}

}
