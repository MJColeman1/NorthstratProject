package com.northstrat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstrat.expense.entities.Travel;
import com.northstrat.expense.entities.User;
import com.northstrat.repositories.TravelRepository;
import com.northstrat.repositories.UserRepository;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	private TravelRepository tr;
	
	@Autowired
	private UserRepository ur;
	
	@Override
	public Travel findById(int id) {
		return tr.findById(id);
	}

	@Override
	public Travel findByTripLocation(String location) {
		return tr.findByTripLocation(location);
	}

	@Override
	public Travel findByStatus(String status) {
		return tr.findByStatus(status);
	}

	@Override
	public Travel createTravelByLoggedInUser(Travel travel, int id) {
		User u = ur.findById(id);
		travel.setUser(u);
		return tr.saveAndFlush(travel);
		
	}

	@Override
	public Travel updateTravelByLoggedInUser(Travel travel, int travelId, int userId) {
		User u = ur.findById(userId);
		Travel managed = tr.findById(travelId);
		managed.setUser(u);
		managed.setStatus(travel.getStatus());
		managed.setProjectChargeCode(travel.getProjectChargeCode());
		managed.setTotalCost(travel.getTotalCost());
		managed.setTravelDates(travel.getTravelDates());
		managed.setTripLocation(travel.getTripLocation());
		return tr.saveAndFlush(managed);
	}

	@Override
	public List<Travel> show(String username) {
		return tr.findAll();
	}

//	@Override
//	public boolean destroyTravelByLoggedInUser(int travelId, int userId) {
//		User u = ur.findById(userId);
//		Travel t = tr.findById(travelId);
////		t.setUser(u);
//		t.getUser().setTravel(null);
//		try {
//			tr.delete(t);;
//			return true;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}

}
