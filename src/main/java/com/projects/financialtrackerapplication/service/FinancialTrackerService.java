package com.projects.financialtrackerapplication.service;

import java.util.List;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;

public interface FinancialTrackerService {
	public void addExpense(Expense expense);
	
	public List<Expense> getExpensesByUserId(User user);
}
