package com.projects.financialtrackerapplication.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projects.financialtrackerapplication.entity.User;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;

@Component
public class FinancialTrackerUtil {
	
	@Autowired
	private FinancialTrackerService service;

	public User findUserById(long userId) {
		return service.getUserById(userId);
	}
	
	public java.sql.Date convertEpochToSqlDate(String timestamp){
		return new java.sql.Date(Long.parseLong(timestamp));
	}
}
