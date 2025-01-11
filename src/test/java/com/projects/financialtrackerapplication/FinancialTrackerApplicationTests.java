package com.projects.financialtrackerapplication;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@SpringBootTest
//@TestPropertySource(
//		  locations = "classpath:application.properties")
class FinancialTrackerApplicationTests {
	@Autowired
	FinancialTrackerService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void addExpense() {
//		try {
//			Expense exp = new Expense();
//			
//			exp.setAmount(3000);
//			exp.setDescription("Bought Soundcore earphones for subhadeep");
//			exp.setTimestamp(new java.sql.Date(System.currentTimeMillis()));
//			exp.setUserId(1);
//			
//			service.addExpense(exp);
//		} catch(Exception e) {
//			System.out.println("Unable to add expense in DB");
//			
//			e.printStackTrace();
//		}
		
		
		
		Assertions.assertThat(service.getUserById(1L).getName()).equals("Ayaan");
	}

}
