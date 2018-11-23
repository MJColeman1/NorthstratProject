package com.northstrat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.northstrat.expense.entities.Expense;
import com.northstrat.services.ExpenseService;

@RestController
@RequestMapping(path = "/api")
public class ExpenseController {
	
	@Autowired
	private ExpenseService es;
	
	@RequestMapping(path = "/expense/{id}", method = RequestMethod.GET)
	public Expense findById(@PathVariable int id) {
		return es.findById(id);
	}
	
	@RequestMapping(path = "/expensestatus/{status}", method = RequestMethod.GET)
	public Expense findByStatus(@PathVariable String status) {
		return es.findByStatus(status);
	}
	
//	@RequestMapping(path = "/expense", method = RequestMethod.POST) 
//	public Expense createExpense(@RequestBody Expense expense) {
//		return es.createExpense(expense);
//	}
	
	@RequestMapping(path = "/user/{id}/expense", method = RequestMethod.POST)
	public Expense createExpense(@RequestBody Expense expense, @PathVariable int id) {
		return es.createExpenseByLoggedInUser(expense, id);
	}
	
	@RequestMapping(path = "/user/{userId}/expense/{expenseId}", method = RequestMethod.PUT) 
	public Expense updateExpense(@RequestBody Expense expense, @PathVariable int expenseId, 
			@PathVariable int userId) {
		return es.updateExpenseByLoggedInUser(expense, expenseId, userId);
	}
	
	
	

}
