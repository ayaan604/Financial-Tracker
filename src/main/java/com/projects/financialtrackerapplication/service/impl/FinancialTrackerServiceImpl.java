package com.projects.financialtrackerapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;
import com.projects.financialtrackerapplication.repository.ExpenseRepository;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@Service
public class FinancialTrackerServiceImpl implements FinancialTrackerService {
	
	@Autowired
	private ExpenseRepository repository;
	
	@Override
	public void addExpense(Expense expense) {
		repository.save(expense);
	}

	@Override
	public List<Expense> getExpensesByUserId(User user) {
		return repository.findByUserId(user.getUserId());
	}

}
