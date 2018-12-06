package com.northstrat.expense.tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.northstrat.expense.entities.Expense;

class ExpenseTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Expense expense;

	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Northstrat");
		em = emf.createEntityManager();
		expense = em.find(Expense.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		expense = null;
	}

	@Test
	@DisplayName("Test Expense is correctly mapped")
	void testExpenseMappings() {
		assertEquals("test", expense.getDescription());
		assertEquals("testing", expense.getAttendees());
		assertEquals("111000", expense.getGlAccount());
		assertEquals("Submitted", expense.getStatus());
		assertEquals(1, expense.getUser().getId());
		assertEquals("test", expense.getUserComments());
		assertEquals("test", expense.getAdminComments());
	}

}
