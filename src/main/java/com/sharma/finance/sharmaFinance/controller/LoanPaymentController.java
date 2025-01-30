package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.LoanPayment;
import com.sharma.finance.sharmaFinance.service.LoanPaymentService;

@RestController
public class LoanPaymentController {

	@Autowired
	LoanPaymentService loanPaymentService;
	
	@GetMapping("/loan-payment")
	public List<LoanPayment> findAllLoan(){
		return loanPaymentService.findAllLoanPayment();
	}
}
