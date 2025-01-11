package com.projects.financialtrackerapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@RestController
@RequestMapping("/FinancialTracker")
public class FinancialTrackerRestController {
	
	public static final String THIS_COMPONENT = FinancialTrackerRestController.class.getName();
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	FinancialTrackerService service;
	
	@PostMapping(path = "/addExpense")
	public String addExpense(String requestJson) {
		Expense expense;
		String response = "";
		
		try {
			expense	= mapper.readValue(requestJson, Expense.class);
			
			service.addExpense(expense);
			
			System.out.println("Expense added to DB : " + expense);
			
			
			
		} catch(Exception e) {
			System.out.println("Exception encountered in "+THIS_COMPONENT + " while adding expense");
			e.printStackTrace();
		}
		
		return response;
	}
}
