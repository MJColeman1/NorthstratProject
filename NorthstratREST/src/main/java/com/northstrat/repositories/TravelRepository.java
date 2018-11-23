package com.northstrat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northstrat.expense.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	Travel findById(int id);
	
	Travel findByTripLocation(String location);
	
	Travel findByStatus(String status);

}
