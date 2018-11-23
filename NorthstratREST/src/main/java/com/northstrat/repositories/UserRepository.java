package com.northstrat.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.northstrat.expense.entities.User;

public interface UserRepository extends JpaRepository <User, Integer> {
	
	public User findByUsernameIgnoreCase(String username);
	
	public User findById(int id);

}
