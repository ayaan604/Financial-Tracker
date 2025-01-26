package com.projects.financialtrackerapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;
import com.projects.financialtrackerapplication.repository.ExpenseRepository;
import com.projects.financialtrackerapplication.repository.UserJDBC;
import com.projects.financialtrackerapplication.repository.UserRepository;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@Service
public class FinancialTrackerServiceImpl implements FinancialTrackerService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	UserJDBC jdbc;
	
	@Override
	public void addExpense(Expense expense) {
		expenseRepository.save(expense);
		
		System.out.println("Expense successfully added to DB : " + expense);
	}
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
		
		System.out.println("User successfully added to DB : " + user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findByUserId(id);
	}

	@Override
	public List<Expense> getExpensesByUser(User user) {
		return expenseRepository.findByUser(user);
	}

	@Override
	@Transactional
	public void registerUser(User user, String password) throws Exception {
		String username = user.getEmail();
		
		System.out.println("Inserting user auth -> " + username + " : " + password);
		jdbc.insertUserAuth(username, password);
		
		System.out.println("Saving user in DB : " + user);
		userRepository.save(user);
	}

}
