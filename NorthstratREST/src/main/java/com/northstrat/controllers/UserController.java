package com.northstrat.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.northstrat.expense.entities.User;
import com.northstrat.services.UserService;

@RestController
@CrossOrigin({"*", "http://localhost:4200"})
@RequestMapping(path = "/api")
public class UserController {
	
	@Autowired
	private UserService us;

	
	@RequestMapping(path="/user/{id}", method = RequestMethod.GET) 
	public User findUserById(@PathVariable int id) {
		return us.findById(id);
	}
	
	@RequestMapping(path="/user", method = RequestMethod.GET)
	public User findUser(Principal principal, HttpServletResponse res) {
		User u = us.findByUsername(principal.getName());
		if (u != null) {
			res.setStatus(200);
			return u;
		}
		res.setStatus(400);
		return null;
	}
	
	@RequestMapping(path="/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return us.createUser(user);
	}
	
	@RequestMapping(path = "/updateuser", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user, Principal principal) {
		return us.updateUser(user, principal.getName());
	}
	
	@RequestMapping(path = "/updatepassword", method = RequestMethod.PUT)
	public User updatePassword(@RequestBody User user, Principal principal) {
		return us.updatePassword(user, principal.getName());
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> show()  {
		return us.show();
	}
}
