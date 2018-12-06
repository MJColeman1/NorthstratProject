package com.northstrat.expense.tests;


import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.northstrat.expense.entities.Travel;

class TravelTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Travel travel;

	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Northstrat");
		em = emf.createEntityManager();
		travel = em.find(Travel.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		travel = null;
	}

	@Test
	@DisplayName("Test Travel is correctly mapped")
	void testTravelMappings() {
		assertEquals("1", travel.getProjectChargeCode());
		assertEquals("Hawaii", travel.getTripLocation());
		assertEquals("8/12/18-8/18/18", travel.getTravelDates());
		assertEquals("Submitted", travel.getStatus());
		assertEquals(2000, travel.getTotalCost(), 1);
		assertEquals(1, travel.getUser().getId());
		assertEquals("test", travel.getAdminComments());
		assertEquals("test", travel.getUserComments());
	}

}
