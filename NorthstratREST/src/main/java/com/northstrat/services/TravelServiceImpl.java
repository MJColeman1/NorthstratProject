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
	public Travel createTravelByLoggedInUser(Travel travel, String username) {
		User u = ur.findByUsernameIgnoreCase(username);
		travel.setUser(u);
		travel.setStatus("Submitted for Review");
		return tr.saveAndFlush(travel);
		
	}

	@Override
	public Travel updateTravelByLoggedInUser(Travel travel, int travelId, String username) {
		User u = ur.findByUsernameIgnoreCase(username);
		Travel managed = tr.findById(travelId);
		managed.setUser(u);
		managed.setProjectChargeCode(travel.getProjectChargeCode());
		managed.setTotalCost(travel.getTotalCost());
		managed.setTravelDates(travel.getTravelDates());
		managed.setTripLocation(travel.getTripLocation());
		managed.setUserComments(travel.getUserComments());
		managed.setStatus("Submitted for Review");
		
		return tr.saveAndFlush(managed);
	}

	@Override
	public List<Travel> index(String username) {
		List<Travel> travelReports = tr.findByUserUsername(username);
		return travelReports;
	}

	@Override
	public boolean destroyTravel(int travelId) {
		try {
			tr.removeUserData(travelId);
			tr.deleteById(travelId);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Travel> findAllTravel(String username) {
		return tr.findAll();
	}

	@Override
	public Travel updateTravelByAdmin(Travel travel, int travelId, String username) {
		Travel managed = tr.findById(travelId);
		managed.setStatus(travel.getStatus());
		managed.setAdminComments(travel.getAdminComments());
		return tr.saveAndFlush(managed);
	}
}
