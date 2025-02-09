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
	
	@GetMapping("/loan")
	public ResponseEntity<?> findAllLoan(){
		return loanService.findAllLoan();
	}
	
	@GetMapping("/loan/{loanId}")
	public ResponseEntity<Loan> findLoanByEntityId(@PathVariable Long loanId){
		return loanService.findLoanById(loanId);
	}
	
	
	@PostMapping("/loan")
	public ResponseEntity<?> createNewLoan(@RequestBody Loan newloan){
		return loanService.createNewLoan(newloan);
	}
	
	@PutMapping("/loan/{loanId}")
	public ResponseEntity<?> updateLoan(@PathVariable Long loanId,@RequestBody Loan loan) {
		return loanService.updateLoan(loanId, loan);
	}
	
	
	@DeleteMapping("lone/{loanId}")
	public ResponseEntity<?> deleteLoan(@PathVariable Long loanId){
		return loanService.deleteLoan(loanId);
	}
	
	
	
}
