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
	
	private long userId;
	private long amount;
	private String description;
	private java.sql.Date timestamp;
	
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public java.sql.Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(java.sql.Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", userId=" + userId + ", amount=" + amount + ", description="
				+ description + ", timestamp=" + timestamp + "]";
	}
}
