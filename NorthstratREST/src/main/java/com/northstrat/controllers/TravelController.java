package com.northstrat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.northstrat.expense.entities.Travel;
import com.northstrat.services.TravelService;

@RestController
@RequestMapping(path = "/api")
public class TravelController {
	
	@Autowired 
	private TravelService ts;
	
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
	
	@RequestMapping(path = "/user/{id}/travel", method = RequestMethod.POST)
	public Travel createTravel(@RequestBody Travel travel, @PathVariable int id) {
		return ts.createTravelByLoggedInUser(travel, id);
	}

	@RequestMapping(path = "/user/{userId}/travel/{travelId}", method = RequestMethod.PUT)
	public Travel updateTravel(@RequestBody Travel travel, @PathVariable int travelId, @PathVariable int userId) {
		return ts.updateTravelByLoggedInUser(travel, travelId, userId);
	}
	
//	@RequestMapping(path = "/user/{userId}/travel/{travelId}", method = RequestMethod.DELETE)
//	public Boolean delete(@PathVariable int userId, @PathVariable int travelId) {
//		return ts.destroyTravelByLoggedInUser(travelId, userId);
//	}
	
	@RequestMapping(path = "/travel", method = RequestMethod.GET)
	public List<Travel> show() {
		return ts.show();
	}
}
