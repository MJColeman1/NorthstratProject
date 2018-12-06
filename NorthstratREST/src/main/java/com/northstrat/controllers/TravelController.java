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

import com.northstrat.expense.entities.Travel;
import com.northstrat.expense.entities.User;
import com.northstrat.services.TravelService;
import com.northstrat.services.UserService;

@RestController
@CrossOrigin({"*", "http://localhost:4200"})
@RequestMapping(path = "/api")
public class TravelController {
	
	@Autowired 
	private TravelService ts;
	
	@Autowired
	private UserService us;
	
	@RequestMapping(path = "/travel/{id}", method = RequestMethod.GET)
	public Travel findById(@PathVariable int id) {
		return ts.findById(id);
	}
	
	@RequestMapping(path = "/location/{location}", method = RequestMethod.GET)
	public Travel findByTripLocation(@PathVariable String location) {
		return ts.findByTripLocation(location);
	}
	
	@RequestMapping(path = "/travelstatus/{status}", method = RequestMethod.GET)
	public Travel findByStatus(@PathVariable String status) {
		return ts.findByStatus(status);
	}
	
	@RequestMapping(path = "/travel", method = RequestMethod.POST)
	public Travel createTravel(@RequestBody Travel travel, Principal principal, HttpServletResponse res) {
		User u = us.findByUsername(principal.getName());
		if (u != null) {
			res.setStatus(200);
			return ts.createTravelByLoggedInUser(travel, principal.getName());
		}
		res.setStatus(401);
		return null;
	}

	@RequestMapping(path = "/travel/{travelId}", method = RequestMethod.PUT)
	public Travel updateTravel(@RequestBody Travel travel, @PathVariable int travelId, 
			Principal principal, HttpServletResponse res) {
		User u = us.findByUsername(principal.getName());
		if (u != null) {
			res.setStatus(200);
			return ts.updateTravelByLoggedInUser(travel, travelId, principal.getName());
		}
		res.setStatus(401);
		return null;
	}
	
	@RequestMapping(path = "/travel", method = RequestMethod.GET)
	public List<Travel> index(Principal principal, HttpServletResponse res) {
			return ts.index(principal.getName());
		}
	
	@RequestMapping(path = "/destroytravel/{travelId}", method = RequestMethod.DELETE)
	public boolean destroyTravel(@PathVariable int travelId) {
		return ts.destroyTravel(travelId);
	}
	
	@RequestMapping(path = "/alltravel", method = RequestMethod.GET)
	public List<Travel> getAllTravel(Principal principal) {
		return ts.findAllTravel(principal.getName());
	}
	
	@RequestMapping(path = "/admintravelupdate/{travelId}", method = RequestMethod.PUT)
	public Travel updateTravelByAdmin(@RequestBody Travel travel, 
			@PathVariable int travelId, Principal principal) {
		return ts.updateTravelByAdmin(travel, travelId, principal.getName());
	}
}
