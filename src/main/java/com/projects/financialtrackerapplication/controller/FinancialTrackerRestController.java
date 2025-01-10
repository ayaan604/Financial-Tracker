package com.projects.financialtrackerapplication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FinancialTracker")
public class FinancialTrackerRestController {
	
	@PostMapping(path = "/addExpense")
	public String addExpense(String requestJson) {
		return "";
	}
}
