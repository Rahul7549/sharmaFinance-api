package com.sharma.finance.sharmaFinance.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sharma.finance.sharmaFinance.exception.ResourceNotFoundException;
import com.sharma.finance.sharmaFinance.model.Loan;
import com.sharma.finance.sharmaFinance.model.LoanPayment;
import com.sharma.finance.sharmaFinance.model.Member;
import com.sharma.finance.sharmaFinance.repository.LoanRepository;
import com.sharma.finance.sharmaFinance.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class LoanService {

	private static List<Loan> loans = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(LoanPaymentService.class);
	
//    static {
//    	loans.add(new Loan(1,  new BigDecimal("5000.00"), new BigDecimal("5.0"),
//    			new BigDecimal("4500.00"), "Approved"));
//        loans.add(new Loan(2, new BigDecimal("2000.00"), new BigDecimal("3.0"),
//        		new BigDecimal("1900.00"), "Pending"));
//
//    }
    
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    MemberRepository memberRepository;
    
    public ResponseEntity<List<Loan>> findAllLoan(){
    	var  loans=loanRepository.findAll();
    	if(loans.isEmpty())
    	{
    		return ResponseEntity.ok(Collections.emptyList());
    	}
    	
    	return ResponseEntity.ok(loans);
    }
    
    
    public ResponseEntity<Loan> findLoanById(Long loanId){
    	return loanRepository.findById(loanId)
    			.map(ResponseEntity::ok)
    			.orElseGet(()->ResponseEntity.notFound().build());
    }
    
    public ResponseEntity<List<Loan>> findAllLoanByEntityId(Long loanId){
    	List<Loan> loans= loanRepository.findAllById(Collections.singletonList(loanId));
    	if(loans.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(loans);
    }
    
    
    public ResponseEntity<?> createNewLoan(Loan newLoan){
    	try {
    		
//    		Member member = memberRepository.findById(newLoan.getMember().getMemberId())
//    		        .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID " + 					newLoan.getMember().getMemberId()));
//    		
//    		logger.info(member.toString());
//    		//logger.info(member.);
//    		newLoan.setMember(member);
    		Loan  createdLoan=loanRepository.save(newLoan);
    		return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "An unexpected error occurred while saving the loan payment."));
		}
    	
    }
    
    
    @Transactional
    public ResponseEntity<?> updateLoan(Long loanId,Loan newLoan){
    	try {
			Loan existingLoan=loanRepository.findById(loanId)
					.orElseThrow(()->new ResourceNotFoundException("Loan not found with ID:" + 					loanId));
			
			existingLoan.setLoanAmount(newLoan.getLoanAmount());
			existingLoan.setLoanBalance(newLoan.getLoanBalance());
			existingLoan.setLoanStatus(newLoan.getLoanStatus());
			existingLoan.setInterestRate(newLoan.getInterestRate());
			Loan updatedLoan=loanRepository.save(existingLoan);
			logger.info("Loan updated uuccessfully with ID" +loanId);
			return ResponseEntity.ok(updatedLoan);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "An unexpected error occurred while saving the loan payment."));
		}
    }
    
    @Transactional
    public ResponseEntity<?> deleteLoan(long loanId){
    	try {
			Loan existingLoan=loanRepository.findById(loanId)
				.orElseThrow(()-> new ResourceNotFoundException("Loan not found with ID:" + 				loanId));
			
			loanRepository.delete(existingLoan);
			logger.info("Loan deleted successfully with ID ",+loanId);
			return ResponseEntity.ok("Loan deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "An unexpected error occurred while saving the loan payment."));
		}
    }
	
}
