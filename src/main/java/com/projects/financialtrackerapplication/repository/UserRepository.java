package com.projects.financialtrackerapplication.repository;

import com.projects.financialtrackerapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
	public User findByUserId(long userId);
}
