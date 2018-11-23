package com.northstrat.services;

import com.northstrat.expense.entities.Expense;

public interface ExpenseService {

	Expense findById(int id);
	
	Expense findByStatus(String status);
	
	Expense createExpense(Expense expense);
	
	Expense createExpenseByLoggedInUser(Expense expense, int id);
	
}
