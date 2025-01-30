package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.Loan;
import com.sharma.finance.sharmaFinance.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	LoanService loanService;
	
	@GetMapping("/loan")
	public List<Loan> findAllLoan(){
		return loanService.findAllLoan();
	}
}
