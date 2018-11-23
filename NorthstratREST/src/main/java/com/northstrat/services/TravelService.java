package com.northstrat.services;

import com.northstrat.expense.entities.Travel;

public interface TravelService {
	
	Travel findById(int id);
	
	Travel findByTripLocation(String location);
	
	Travel findByStatus(String status);
	
	Travel createTravelByLoggedInUser(Travel travel, int id);
	
	Travel updateTravelByLoggedInUser(Travel travel, int travelId, int id);
	
	boolean destroyTravelByLoggedInUser(int travelId, int userId);

}
