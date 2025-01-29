package com.projects.financialtrackerapplication.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long expenseId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	private long amount;
	private String description;
	private java.sql.Date timestamp;
	
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", user=" + user.getName() + ", amount=" + amount + ", description="
				+ description + ", timestamp=" + timestamp + "]";
	}
}
