package com.northstrat.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.northstrat.expense.entities.Expense;
import com.northstrat.expense.entities.User;
import com.northstrat.services.ExpenseService;
import com.northstrat.services.UserService;

@RestController
@CrossOrigin({ "*", "http://localhost:4200" })
@RequestMapping(path = "/api")
public class ExpenseController {

	@Autowired
	private ExpenseService es;
	
	@Autowired
	private UserService us;

	@RequestMapping(path = "/expense/{id}", method = RequestMethod.GET)
	public Expense findById(@PathVariable int id) {
		return es.findById(id);
	}

	@RequestMapping(path = "/expensestatus/{status}", method = RequestMethod.GET)
	public Expense findByStatus(@PathVariable String status) {
		return es.findByStatus(status);
	}

	// @RequestMapping(path = "/expense", method = RequestMethod.POST)
	// public Expense createExpense(@RequestBody Expense expense) {
	// return es.createExpense(expense);
	// }

	@RequestMapping(path = "/expense", method = RequestMethod.POST)
	public Expense createExpense(@RequestBody Expense expense, Principal principal, HttpServletResponse res) {
		User u = us.findByUsername(principal.getName());
		if (u != null) {
			res.setStatus(200);
			return es.createExpenseByLoggedInUser(expense, principal.getName());
		}
		res.setStatus(401);
		return null;
	}

	@RequestMapping(path = "/expense/{expenseId}", method = RequestMethod.PUT)
	public Expense updateExpense(@RequestBody Expense expense, @PathVariable int expenseId,
			Principal principal, HttpServletResponse res) {
		User u = us.findByUsername(principal.getName());
		if (u != null) {
			res.setStatus(200);
			return es.updateExpenseByLoggedInUser(expense, expenseId, principal.getName());
		}
		res.setStatus(401);
		return null;
	}

	@RequestMapping(path = "/expenses", method = RequestMethod.GET)
	public List<Expense> index(Principal principal) {
		return es.index(principal.getName());
	}
	
	@RequestMapping(path = "/destroyexpense/{expenseId}", method = RequestMethod.DELETE)
	public boolean destroyExpenseReport(@PathVariable int expenseId) {
		return es.destroyExpense(expenseId);
	}
	
	@RequestMapping(path = "/allexpenses", method = RequestMethod.GET)
	public List<Expense> getAllExpenses(Principal principal) {
		return es.findAllExpenses(principal.getName());
	}
	
	@RequestMapping(path = "/adminexpenseupdate/{expenseId}", method = RequestMethod.PUT)
	public Expense updateExpenseByAdmin(@RequestBody Expense expense, 
			@PathVariable int expenseId, Principal principal) {
		return es.updateExpenseByAdmin(expense, expenseId, principal.getName());
	}

}
