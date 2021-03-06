package com.northstrat.services;

import java.util.List;

import javax.persistence.NoResultException;

import com.northstrat.expense.entities.User;

public interface UserService {
	
	
	User findById(int id);
	
	User findByUsername(String username);

	User createUser(User user);
	
	User updateUser(User user, String username);
	
	User updatePassword(User user, String username);
	
	List<String> indexOfUsernames();
	
	public User authenticateUser(User user) throws NoResultException;

}
