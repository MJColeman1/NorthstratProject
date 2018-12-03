package com.northstrat.services;

import java.util.List;

import javax.persistence.NoResultException;

import com.northstrat.expense.entities.User;

public interface UserService {
	
	
	User findById(int id);
	
	User findByUsername(String username);

	User createUser(User user);
	
	User updateUser(User user, int userId);
	
	List<User> show();
	
	public User authenticateUser(User user) throws NoResultException;

}
