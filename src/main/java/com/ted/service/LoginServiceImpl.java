package com.ted.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ted.model.Authority;
import com.ted.model.AuthorityPK;
import com.ted.model.User;
import com.ted.model.UserPicture;
import com.ted.repository.AuthorityRepository;
import com.ted.repository.UserPictureRepository;
import com.ted.repository.UserRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private UserPictureRepository userPictureRepository;
	
	@Autowired
	private UserService userService;

	@Transactional
	public User saveUser(User user, MultipartFile file) {
		
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
		
		// Picture
		if(!file.isEmpty()) {
			UserPicture picture = new UserPicture();
			try {
				picture.setContent(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			picture.setUser(user);
			userPictureRepository.saveAndFlush(picture);
		}
		
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

	public String checkEmailUsername(User user) {
		
		if(userRepository.findByEmail(user.getEmail()) != null )
			return "Email already in use";
		if(userRepository.findByUsername(user.getUsername()) != null )
			return "Username already in use";	
		return null;
	}

	@Transactional
	public String upgradeUser(Map<String, String> params) {
		
		User user = userService.getLoggedInUser();
		if(user == null)
			return "Please login and try again.";
		
		/* Address */
		String address = params.get("address");
		if(address.isEmpty())
			return "Please provide an Address.";
		user.setAddress(address);
		
		/* Postal Code */
		String postalCode = params.get("postalCode");
		if(postalCode.isEmpty())
			return "Please provide an Postal Code.";
		user.setPostalCode(postalCode);
		
		/* AFM */
		String afm = params.get("afm");
		if(afm.isEmpty())
			return "Please provide an AFM.";
		user.setAfm(afm);
		
		/* Update User */
		user = userRepository.saveAndFlush(user);
		
		/* Authority */
		AuthorityPK authorityPK = new AuthorityPK();
		authorityPK.setUserid(user.getUserid());
		authorityPK.setRole("ROLE_SELLER");
		
		Authority authority = new Authority();
		authority.setId(authorityPK);
		authority.setUser(user);
		
		/* Persist authority */
		authorityRepository.save(authority);
		
		return null;
	}

}
