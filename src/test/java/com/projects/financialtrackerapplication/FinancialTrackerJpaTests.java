package com.projects.financialtrackerapplication;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.entity.User;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan("com.projects.financialtrackerapplication")
public class FinancialTrackerJpaTests {
	@Autowired
	FinancialTrackerService service;
	
	@Test
//	@Disabled
	public void getUserById() {
		Assertions.assertThat(service.getUserById(1L).getName()).isEqualTo("Ayaan");
	}
	
	@Test
	public void getExpenses() {
		User user = service.getUserById(1);
		List<Expense> expenses = service.getExpensesByUser(user);
		
		expenses.stream().forEach(System.out::println);
	}
}
