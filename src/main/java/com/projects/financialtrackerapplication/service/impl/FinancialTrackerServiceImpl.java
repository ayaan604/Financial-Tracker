package com.projects.financialtrackerapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;
import com.projects.financialtrackerapplication.repository.ExpenseRepository;
import com.projects.financialtrackerapplication.repository.UserRepository;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@Service
public class FinancialTrackerServiceImpl implements FinancialTrackerService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addExpense(Expense expense) {
		expenseRepository.save(expense);
		
		System.out.println("Expense successfully added to DB : " + expense);
	}

	@Override
	public List<Expense> getExpensesByUserId(Long id) {
		return expenseRepository.findByUserId(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
		
		System.out.println("User successfully added to DB : " + user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.getById(id);
	}

}
