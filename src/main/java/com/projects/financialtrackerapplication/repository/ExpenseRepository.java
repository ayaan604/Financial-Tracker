package com.projects.financialtrackerapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.financialtrackerapplication.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{
	public List<Expense> findByUserId(long userId);
}
