package com.northstrat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.northstrat.expense.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	Travel findById(int id);
	
	Travel findByTripLocation(String location);
	
	Travel findByStatus(String status);
	
	List<Travel> findByUserUsername(String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE Travel t SET user_id = null where t.id = :travelId")
	void removeUserData(@Param("travelId") int travelId);

}
