package com.projects.financialtrackerapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long expenseId;
	
	private String userId;
	private long amount;
	private String description;
	private java.sql.Date timestamp;
	
	
}
