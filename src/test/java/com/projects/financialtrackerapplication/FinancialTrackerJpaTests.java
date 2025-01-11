package com.projects.financialtrackerapplication;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

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
}
