package com.northstrat.services;

import java.util.List;

import com.northstrat.expense.entities.Expense;

public interface ExpenseService {

	Expense findById(int id);
	
	Expense findByStatus(String status);
	
	Expense createExpense(Expense expense);
	
	Expense createExpenseByLoggedInUser(Expense expense, String username);
	
	Expense updateExpenseByLoggedInUser(Expense expense, int expenseId, String username);
	
	List<Expense> index(String username);
	
	List<Expense> findAllExpenses(String username);
	
	boolean destroyExpense(int id);
	
	Expense updateExpenseByAdmin(Expense expense, int expenseId, String username);
	
}
