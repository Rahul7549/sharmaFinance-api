package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sharma.finance.sharmaFinance.model.Loan;
import com.sharma.finance.sharmaFinance.service.LoanService;

@RestController()
public class LoanController {

	@Autowired
	LoanService loanService;
	
	@GetMapping("/loans")
	public ResponseEntity<?> findAllLoan(){
		return loanService.findAllLoan();
	}
	
	@GetMapping("/loans/{loanId}")
	public ResponseEntity<Loan> findLoanByEntityId(@PathVariable Long loanId){
		return loanService.findLoanById(loanId);
	}
	
	
	@PostMapping("/loans")
	public ResponseEntity<?> createNewLoan(@RequestBody Loan newloan){
		return loanService.createNewLoan(newloan);
	}
	
	@PutMapping("/loans/{loanId}")
	public ResponseEntity<?> updateLoan(@PathVariable Long loanId,@RequestBody Loan loan) {
		return loanService.updateLoan(loanId, loan);
	}
	
	
	@DeleteMapping("loans/{loanId}")
	public ResponseEntity<?> deleteLoan(@PathVariable Long loanId){
		return loanService.deleteLoan(loanId);
	}
	
	
	
}
