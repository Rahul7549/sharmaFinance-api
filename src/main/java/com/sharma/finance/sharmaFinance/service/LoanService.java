package com.sharma.finance.sharmaFinance.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.finance.sharmaFinance.model.Loan;
import com.sharma.finance.sharmaFinance.repository.LoanRepository;

@Service
public class LoanService {

	private static List<Loan> loans = new ArrayList<>();
    static {
    	loans.add(new Loan(1,  new BigDecimal("5000.00"), new BigDecimal("5.0"), 
    			new BigDecimal("4500.00"), "Approved"));
        loans.add(new Loan(2, new BigDecimal("2000.00"), new BigDecimal("3.0"), 
        		new BigDecimal("1900.00"), "Pending"));
  
    }
    
    @Autowired
    LoanRepository loanRepository;
    
    public List<Loan> findAllLoan(){
    	var  loans=loanRepository.findAll();
    	
    	return loans;
    }
	
}
