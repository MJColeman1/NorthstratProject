package com.northstrat.services;

import java.util.List;

import com.northstrat.expense.entities.Travel;

public interface TravelService {
	
	Travel findById(int id);
	
	Travel findByTripLocation(String location);
	
	Travel findByStatus(String status);
	
	Travel createTravelByLoggedInUser(Travel travel, String username);
	
	Travel updateTravelByLoggedInUser(Travel travel, int travelId, String username);
	
	List<Travel> index(String username);
	
//	boolean destroyTravelByLoggedInUser(int travelId, int userId);

}
