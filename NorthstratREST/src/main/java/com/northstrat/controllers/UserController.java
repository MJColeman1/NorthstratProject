package com.northstrat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.northstrat.expense.entities.User;
import com.northstrat.services.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {
	
	@Autowired
	private UserService us;

	
	@RequestMapping(path="/user/{id}", method = RequestMethod.GET) 
	public User findUserById(@PathVariable int id) {
		return us.findById(id);
	}
	
	@RequestMapping(path="/username/{username}", method = RequestMethod.GET)
	public User findUser(@PathVariable String username) {
		return us.findByUsername(username);
	}
	
	@RequestMapping(path="/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return us.createUser(user);
	}
	
	@RequestMapping(path = "/user/{userId}", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user, @PathVariable int userId) {
		return us.updateUser(user, userId);
	}
}
