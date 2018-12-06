package com.northstrat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northstrat.expense.entities.User;
import com.northstrat.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(String json) {
		ObjectMapper om = new ObjectMapper();
		User user = null;
		
		try {
			user = om.readValue(json, User.class);
			
			String encodedPW = encoder.encode(user.getPassword());
			user.setPassword(encodedPW);
			
			user = userService.createUser(user);
//			userRepo.saveAndFlush(user);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return user;
		
	}

}
