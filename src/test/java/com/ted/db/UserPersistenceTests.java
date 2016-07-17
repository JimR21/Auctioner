package com.ted.db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.User;
import com.ted.repository.UserRepository;

@ContextConfiguration(locations={"classpath:com/ted/db/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserPersistenceTests {
	
	@Autowired
	UserRepository userRepository;

	@Test
	@Transactional
	public void testSaveAndGetAndDelete() throws Exception {
		User user = new User();
		user.setName("Dimitris");
		user.setSurname("Kavva");
		user.setAddress("Reas 8");
		user.setCity("Athens");
		user.setState("Attiki");
		user.setPostalCode("14574");
		user.setPassword("secret");
		user.setPhone("6980796209");
		user.setEmail("mitsos-r21@hotmai.gr");
		
		userRepository.saveAndFlush(user);
		
		List<User> list = userRepository.findAll();
		assertEquals("Dimitris", list.get(0).getName());
	}

}
