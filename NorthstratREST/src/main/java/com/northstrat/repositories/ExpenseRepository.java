package com.northstrat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northstrat.expense.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	
	public Expense findById(int id);
	
	public Expense findByStatus(String status);
	

}
