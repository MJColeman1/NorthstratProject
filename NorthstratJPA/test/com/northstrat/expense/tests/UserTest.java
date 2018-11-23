package com.northstrat.expense.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.northstrat.expense.entities.User;

class UserTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Northstrat");
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		user = null;
	}

	@Test
	@DisplayName("Test user is correctly mapped")
	void testUserMappings() {
		assertEquals("Coleman", user.getUsername());
		assertEquals("password", user.getPassword());
		assertTrue(user.isAdmin());
		assertEquals("Mark", user.getFirstName());
		assertEquals("Coleman", user.getLastName());
		assertEquals("Mark.Coleman@northstrat.com", user.getEmail());
		assertEquals("Software Engineer", user.getTitle());
		assertEquals(1, user.getExpenses().size());
		assertEquals(1, user.getTravel().size());
	}

}
