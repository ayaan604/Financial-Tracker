package com.projects.financialtrackerapplication.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJDBC {
	
	JdbcTemplate template;
	
	private static final String INSERT_USER_QRY = "insert into user_auth (user_name,password)"
			+ " values( ? , ? )";
	
	public UserJDBC(JdbcTemplate template) {
		this.template = template;
	}
	
	public void insertUserAuth(String username, String password) {
		int success = template.update(INSERT_USER_QRY,username,password);
	}
}
