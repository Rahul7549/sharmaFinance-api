package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.Loan;
import com.sharma.finance.sharmaFinance.service.LoanService;

@RestController()
public class LoanController {

	@Autowired
	LoanService loanService;
	
	@GetMapping("/loan")
	public ResponseEntity<?> findAllLoan(){
		return loanService.findAllLoan();
	}
	
	@GetMapping("/loan/{loanId}")
	public ResponseEntity<Loan> findLoanByEntityId(@PathVariable Long loanId){
		return loanService.findLoanById(loanId);
	}
	
	
	@PostMapping("/loan")
	public ResponseEntity<?> createNewLoan(Loan newloan){
		return loanService.createNewLoan(newloan);
	}
	
	@PutMapping("/loan/{loanId}")
	public ResponseEntity<?> updateLoan(@PathVariable Long loanId,Loan loan) {
		return loanService.updateLoan(loanId, loan);
	}
	
	
	@DeleteMapping("lone/{loanId}")
	public ResponseEntity<?> deleteLoan(@PathVariable Long loanId){
		return loanService.deleteLoan(loanId);
	}
	
	
	
}
