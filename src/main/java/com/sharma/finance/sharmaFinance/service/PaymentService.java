package com.sharma.finance.sharmaFinance.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.finance.sharmaFinance.exception.ResourceNotFoundException;
import com.sharma.finance.sharmaFinance.model.Payment;
import com.sharma.finance.sharmaFinance.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private static List<Payment> payments = new ArrayList<>(); 
	
    @Autowired
    PaymentRepository paymentRepository;
    
    public ResponseEntity<?> findAllPayment(){
    	
			List<Payment> payments= paymentRepository.findAll();
			if (payments.isEmpty()) {
				return ResponseEntity.ok(Collections.emptyList());
			}
			return ResponseEntity.ok(payments);
		
    }
    
    public ResponseEntity<?> findPaymentById(Long paymentId) {
    	
			return paymentRepository.findById(paymentId)
					.map(ResponseEntity::ok)
					.orElseThrow(()-> new ResourceNotFoundException("Payment doesn't exist with ID:"+paymentId));
		
	}
    
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createPayments(Payment newPayment){
    	
			Payment payment= paymentRepository.save(newPayment);
			return ResponseEntity.status(HttpStatus.CREATED).body(payment);
		
    }
    
    @Transactional
    public ResponseEntity<?> updatePayment(Long paymentId, Payment newPayment){
    	
			Payment existingPayment=paymentRepository.findById(paymentId)
					.orElseThrow(()-> new ResourceNotFoundException("Paymenst does not exist with ID:"+paymentId));
			
			existingPayment.setAmountPaid(newPayment.getAmountPaid());
			existingPayment.setFine(newPayment.getFine());
			//existingPayment.
			Payment updatedPayment= paymentRepository.save(existingPayment);
			return ResponseEntity.ok(updatedPayment);
		
    }
    
    @Transactional
    public ResponseEntity<?> deletePaymenstById(Long paymentId){
    	
    		Payment payment=paymentRepository.findById(paymentId)
        			.orElseThrow(()-> new ResourceNotFoundException("Paymenst does not exist with ID:"+paymentId));
        	paymentRepository.delete(payment);
        	return ResponseEntity.ok("Paymenst deleted successfully");
        	
        
    }

}
