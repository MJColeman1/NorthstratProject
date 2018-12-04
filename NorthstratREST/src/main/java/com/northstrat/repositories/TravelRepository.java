package com.northstrat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northstrat.expense.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	Travel findById(int id);
	
	Travel findByTripLocation(String location);
	
	Travel findByStatus(String status);
	
	List<Travel> findByUserUsername(String username);

}
