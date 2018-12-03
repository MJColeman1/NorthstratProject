package com.northstrat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstrat.expense.entities.Expense;
import com.northstrat.expense.entities.User;
import com.northstrat.repositories.ExpenseRepository;
import com.northstrat.repositories.UserRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository er;
	
	@Autowired
	private UserRepository ur;

	@Override
	public Expense findById(int id) {
		return er.findById(id);
	}

	@Override
	public Expense findByStatus(String status) {
		return er.findByStatus(status);
	}

	@Override
	public Expense createExpense(Expense expense) {
		Expense e = new Expense();
		e.setDescription(expense.getDescription());
		e.setAttendees(expense.getAttendees());
		e.setGlAccount(expense.getGlAccount());
		e.setStatus(expense.getStatus());
		e.setAmount(expense.getAmount());
		er.saveAndFlush(e);
		return e;
	}

	@Override
	public Expense createExpenseByLoggedInUser(Expense expense, int id) {
		User u = ur.findById(id);
		expense.setUser(u);
		return er.saveAndFlush(expense);
	}

	@Override
	public Expense updateExpenseByLoggedInUser(Expense expense, int expenseId, int userId) {
		User u = ur.findById(userId);
		Expense managed = er.findById(expenseId);
		managed.setDescription(expense.getDescription());
		managed.setAttendees(expense.getAttendees());
		managed.setAmount(expense.getAmount());
		managed.setGlAccount(expense.getGlAccount());
		managed.setStatus(expense.getStatus());
		managed.setUser(u);
		return er.saveAndFlush(managed);
	}

	@Override
	public List<Expense> index(String username) {
		return er.findAll();
	}

}
