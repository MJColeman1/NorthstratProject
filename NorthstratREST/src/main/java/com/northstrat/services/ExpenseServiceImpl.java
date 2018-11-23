package com.northstrat.services;

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
		Expense e = new Expense();
		e.setDescription(expense.getDescription());
		e.setAttendees(expense.getAttendees());
		e.setGlAccount(expense.getGlAccount());
		e.setStatus(expense.getStatus());
		e.setAmount(expense.getAmount());
		e.setUser(u);
		er.saveAndFlush(e);
		return e;
	}

}
