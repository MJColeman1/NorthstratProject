package com.northstrat.services;

import com.northstrat.expense.entities.User;

public interface UserService {
	
	
	User findById(int id);
	
	User findByUsername(String username);

	User createUser(User user);
	
	User updateUser(User user, int userId);

}
