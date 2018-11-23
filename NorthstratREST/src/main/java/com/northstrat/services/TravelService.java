package com.northstrat.services;

import java.util.List;

import com.northstrat.expense.entities.Travel;

public interface TravelService {
	
	Travel findById(int id);
	
	Travel findByTripLocation(String location);
	
	Travel findByStatus(String status);
	
	Travel createTravelByLoggedInUser(Travel travel, int id);
	
	Travel updateTravelByLoggedInUser(Travel travel, int travelId, int id);
	
	List<Travel> show();
	
//	boolean destroyTravelByLoggedInUser(int travelId, int userId);

}
