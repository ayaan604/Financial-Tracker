package com.projects.financialtrackerapplication.service;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;

public interface FinancialTrackerService {
	public void addExpense(Expense expense);
	
	public void getExpensesByUserId(User user);
}
