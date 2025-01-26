package com.projects.financialtrackerapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;
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
//		addExpense();
//		addUser();
//		getExpenseList();
	}
	
	private void addExpense() {
		try {
			Expense exp = new Expense();
			
			exp.setAmount(540);
			exp.setDescription("Zak's Cafe butter chicken pizza");
			exp.setTimestamp(new java.sql.Date(System.currentTimeMillis()));
			exp.setUser(service.getUserById(1));
			
			service.addExpense(exp);
		} catch(Exception e) {
			System.out.println("Unable to add expense in DB");
			
			e.printStackTrace();
		}
		
	}
	
	private void addUser() {
		try {
			User user = new User();
			
			user.setName("Ayaan");
			user.setAge(24);
			user.setEmail("ayaan604shaikh@gmail.com");
			user.setIncome(60000);
			
			service.addUser(user);
		} catch(Exception e) {
			System.out.println("Unable to add user in DB");
			
			e.printStackTrace();
		}
	}
	
	private void getExpenseList() {
		long userId = 1L;
		
//		User user = service.getUserById(userId);

		List<Expense> expenses = service.getExpensesByUser(service.getUserById(userId));
		
		System.out.println("Listing all expenses of user");
		for(Expense exp : expenses) {
			System.out.println(exp);
		}
	}

}
