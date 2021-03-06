package com.northstrat.services;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.northstrat.expense.entities.User;
import com.northstrat.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User createUser(User user) {
//		User u = new User();
//		u.setUsername(user.getUsername());
//		u.setPassword(user.getPassword());
//		u.setFirstName(user.getFirstName());
//		u.setLastName(user.getLastName());
//		u.setTitle(user.getTitle());
//		u.setEmail(user.getEmail());
		user.setEnabled(true);
		user.setRole("user");
		return ur.saveAndFlush(user);
		
	}
	
	public User findById(int id) {
		return ur.findById(id);
	}
	
	public User findByUsername(String username) {
		return ur.findByUsernameIgnoreCase(username);
	}

	@Override
	public User updateUser(User user, String username) {
		User managed = ur.findByUsernameIgnoreCase(username);
		managed.setFirstName(user.getFirstName());
		managed.setLastName(user.getLastName());
		managed.setEmail(user.getEmail());
		managed.setTitle(user.getTitle());
		return ur.saveAndFlush(managed);
		
	}
	
	public User updatePassword(User user, String username) {
		User managed = ur.findByUsernameIgnoreCase(username);
		managed.setUsername(user.getUsername());
		managed.setPassword(encoder.encode(user.getPassword()));
		return ur.saveAndFlush(managed);
	}

	@Override
	public List<String> indexOfUsernames() {
		List<String> usernames = new ArrayList<>();
		List<User> users = ur.findAll();
		for (User user : users) {
			usernames.add(user.getUsername().toUpperCase());
		}
		return usernames;
	}

	@Override
	public User authenticateUser(User user) throws NoResultException {
		User managedUser = ur.findOneUserByUsername(user.getUsername());
		
		if (encoder.matches(user.getPassword(), managedUser.getPassword())) {
			return managedUser;
		}
		return null;
	}



}
