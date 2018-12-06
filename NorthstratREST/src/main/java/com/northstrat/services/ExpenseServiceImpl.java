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
		e.setUserComments(expense.getUserComments());
		er.saveAndFlush(e);
		return e;
	}

	@Override
	public Expense createExpenseByLoggedInUser(Expense expense, String username) {
		User u = ur.findByUsernameIgnoreCase(username);
		expense.setUser(u);
		expense.setStatus("Submitted for Review");
		return er.saveAndFlush(expense);
	}

	@Override
	public Expense updateExpenseByLoggedInUser(Expense expense, int expenseId, String username) {
		User u = ur.findByUsernameIgnoreCase(username);
		Expense managed = er.findById(expenseId);
		managed.setDescription(expense.getDescription());
		managed.setAttendees(expense.getAttendees());
		managed.setAmount(expense.getAmount());
		managed.setGlAccount(expense.getGlAccount());
		managed.setUserComments(expense.getUserComments());
		managed.setStatus("Submitted for Review");
		managed.setUser(u);
		return er.saveAndFlush(managed);
	}

	@Override
	public List<Expense> index(String username) {
		List<Expense> expenseReports = er.findByUserUsername(username);
		return expenseReports;
	}
	
	@Override
	public boolean destroyExpense(int expenseId) {
		try {
			er.removeUserData(expenseId);
			er.deleteById(expenseId);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Expense> findAllExpenses(String username) {
		return er.findAll();
	}

	@Override
	public Expense updateExpenseByAdmin(Expense expense, int expenseId, String username) {
		Expense managed = er.findById(expenseId);
		managed.setStatus(expense.getStatus());
		managed.setAdminComments(expense.getAdminComments());
		return er.saveAndFlush(managed);
	}

}
