package com.northstrat.expense.tests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.northstrat.expense.entities.Profile;

class ProfileTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Profile profile;

	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Northstrat");
		em = emf.createEntityManager();
		profile = em.find(Profile.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test Profile is mapped correctly")
	void testProfileMappings() {
		assertEquals("Mark", profile.getFirstName());
		assertEquals("Coleman", profile.getLastName());
		assertEquals("Mark.coleman@northstrat.com", profile.getEmail());
		assertEquals("Software Engineer", profile.getTitle());
	}

}
