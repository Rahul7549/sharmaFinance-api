package com.sharma.finance.sharmaFinance.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.sharma.finance.sharmaFinance.model.LoanPayment;
import com.sharma.finance.sharmaFinance.repository.LoanPaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class LoanPaymentService {
	
	private static List<LoanPayment> loanPayments = new ArrayList<>();
    
	static {
        loanPayments.add(new LoanPayment(1, LocalDate.of(2025,01,10), 
        		new BigDecimal(500.00), new BigDecimal(4000.00)));
        loanPayments.add(new LoanPayment(2, LocalDate.of(2025,01,20), 
        		new BigDecimal(300.00), new BigDecimal(1600.00)));
    }
	 
	
	@Autowired
	LoanPaymentRepository loanPaymentRepository;
	
	
	public List<LoanPayment> findAllLoanPayment(){
		var loanPayments=loanPaymentRepository.findAll();
		return loanPayments;
	}
}
	
	
	
	
	
	
	
	

