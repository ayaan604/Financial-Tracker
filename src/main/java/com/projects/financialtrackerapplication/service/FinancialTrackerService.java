package com.projects.financialtrackerapplication.service;

import java.util.List;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;

public interface FinancialTrackerService {
	public void addExpense(Expense expense);
	
	public void addUser(User user);
	
	public User getUserById(long id);
	
	public List<Expense> getExpensesByUser(User user);
	
	public void registerUser(User user, String password) throws Exception;
	
	public void deleteUser(User user);
}
