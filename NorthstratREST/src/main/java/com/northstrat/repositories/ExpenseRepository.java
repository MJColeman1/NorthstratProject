package com.northstrat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.northstrat.expense.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	
	public Expense findById(int id);
	
	public Expense findByStatus(String status);
	
	List<Expense> findByUserUsername(String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE Expense e SET user_id = null where e.id = :expenseId")
	void removeUserData(@Param("expenseId") int expenseId);
}
