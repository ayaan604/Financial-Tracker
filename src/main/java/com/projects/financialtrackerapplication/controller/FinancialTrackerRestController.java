package com.projects.financialtrackerapplication.controller;

import static com.projects.financialtrackerapplication.constants.FinancialTrackerConstants.DEFAULT_ERR_RESP;
import static com.projects.financialtrackerapplication.constants.FinancialTrackerConstants.ERROR_CODE_FAILURE;
import static com.projects.financialtrackerapplication.constants.FinancialTrackerConstants.ERROR_CODE_SUCCESS;
import static com.projects.financialtrackerapplication.constants.FinancialTrackerConstants.MSG_EXPENSE_ADDED;
import static com.projects.financialtrackerapplication.constants.FinancialTrackerConstants.MSG_EXPENSE_ADD_FAIL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.financialtrackerapplication.dto.ExpenseDTO;
import com.projects.financialtrackerapplication.dto.TransactionStatus;
import com.projects.financialtrackerapplication.entity.Expense;
import com.projects.financialtrackerapplication.service.FinancialTrackerService;
import com.projects.financialtrackerapplication.util.FinancialTrackerUtil;

@RestController
@RequestMapping("/FinancialTracker")
public class FinancialTrackerRestController {
	
	public static final String THIS_COMPONENT = FinancialTrackerRestController.class.getName();
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	FinancialTrackerService service;
	
	@Autowired
	FinancialTrackerUtil util;
	
	@PostMapping(path = "/addExpense")
	public String addExpense(@RequestBody String requestJson) {
		ExpenseDTO expenseDto = new ExpenseDTO();
		Expense expense = new Expense();
		String response = "";
		TransactionStatus status = new TransactionStatus();
		try {
			System.out.println(requestJson);
			expenseDto	= mapper.readValue(requestJson, ExpenseDTO.class);
			mapExpenseDtoToEntity(expenseDto,expense);
			service.addExpense(expense);
			
			System.out.println("Expense added to DB : " + expense);
			
			status.setErrorCode(ERROR_CODE_SUCCESS);
			status.setErrorMessage(MSG_EXPENSE_ADDED);
			
		} catch(Exception e) {
			System.out.println("Exception encountered in "+THIS_COMPONENT + " while adding expense");
			e.printStackTrace();
			
			status.setErrorCode(ERROR_CODE_FAILURE);
			status.setErrorMessage(MSG_EXPENSE_ADD_FAIL);
		}
		
		try {
			response = mapper.writeValueAsString(status);
		} catch(Exception e) {
			response = DEFAULT_ERR_RESP;
		}
		
		return response;
	}

	private void mapExpenseDtoToEntity(ExpenseDTO expenseDto, Expense expense) {
		expense.setAmount(expenseDto.getAmount());
		expense.setDescription(expenseDto.getDescription());
		
		expense.setTimestamp(util.convertEpochToSqlDate(expenseDto.getTimestamp()));
		expense.setUser(util.findUserById(expenseDto.getUserId()));
	}
}
