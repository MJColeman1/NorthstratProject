package com.northstrat.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstrat.expense.entities.User;
import com.northstrat.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository ur;

	@Override
	public User createUser(User user) {
		User u = new User();
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getFirstName());
		u.setTitle(user.getTitle());
		u.setEmail(user.getEmail());
		ur.saveAndFlush(u);
		return u;
	}
	
	public User findById(int id) {
		return ur.findById(id);
	}
	
	public User findByUsername(String username) {
		return ur.findByUsernameIgnoreCase(username);
	}



}
