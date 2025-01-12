package com.projects.financialtrackerapplication.dto;

public class ExpenseDTO {
	private long userId;
	private long amount;
	private String description;
	private String timestamp;
	
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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ExpenseDTO [userId=" + userId + ", amount=" + amount + ", description=" + description + ", timestamp="
				+ timestamp + "]";
	}
}
