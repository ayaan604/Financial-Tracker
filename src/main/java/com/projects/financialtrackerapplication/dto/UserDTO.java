package com.projects.financialtrackerapplication.dto;

public class UserDTO {
	private String name;
	private int age;
	private String email;
	private long income;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + ", email=" + email + ", income=" + income + ", password="
				+ password + "]";
	}
	
}
