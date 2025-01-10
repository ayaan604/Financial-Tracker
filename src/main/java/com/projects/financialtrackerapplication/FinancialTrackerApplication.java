package com.projects.financialtrackerapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@SpringBootApplication
public class FinancialTrackerApplication implements CommandLineRunner{
	@Autowired
	FinancialTrackerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(FinancialTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Expense exp = new Expense();
		exp.setAmount(500);
		exp.setDescription("Buying a football");
		exp.setTimestamp(new java.sql.Date(System.currentTimeMillis()));
		exp.setUserId(1);
		service.addExpense(null);
	}

}
