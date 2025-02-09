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
//    static {
//        payments.add(new Payment(1, LocalDate.of(2025, 1, 16), new BigDecimal(15.50), new BigDecimal(50.00)));
//        payments.add(new Payment(1, LocalDate.of(2025, 1, 16), new BigDecimal(15.50), new BigDecimal(50.00)));
//         }
//    
    
    @Autowired
    PaymentRepository paymentRepository;
    
    public ResponseEntity<?> findAllPayment(){
    	try {
			List<Payment> payments= paymentRepository.findAll();
			if (payments.isEmpty()) {
				return ResponseEntity.ok(Collections.emptyList());
			}
			return ResponseEntity.ok(payments);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching all payments."));
		}
    }
    
    public ResponseEntity<?> findPaymentById(Long paymentId) {
    	try {
			return paymentRepository.findById(paymentId)
					.map(ResponseEntity::ok)
					.orElseGet(()-> ResponseEntity.notFound().build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching all payments."));
		}
	}
    
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createPayments(Payment newPayment){
    	try {
			Payment payment= paymentRepository.save(newPayment);
			return ResponseEntity.status(HttpStatus.CREATED).body(payment);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while creating payment."));

		}
    }
    
    @Transactional
    public ResponseEntity<?> updatePayment(Long paymentId, Payment newPayment){
    	try {
			Payment existingPayment=paymentRepository.findById(paymentId)
					.orElseThrow(()-> new ResourceNotFoundException("Paymenst does not exist with ID:"+paymentId));
			
			existingPayment.setAmountPaid(newPayment.getAmountPaid());
			existingPayment.setFine(newPayment.getFine());
			//existingPayment.
			Payment updatedPayment= paymentRepository.save(existingPayment);
			return ResponseEntity.ok(updatedPayment);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching all payments."));
		}
    }
    
    @Transactional
    public ResponseEntity<?> deletePaymenstById(Long paymentId){
    	try {
    		Payment payment=paymentRepository.findById(paymentId)
        			.orElseThrow(()-> new ResourceNotFoundException("Paymenst does not exist with ID:"+paymentId));
        	paymentRepository.delete(payment);
        	
        	return ResponseEntity.ok("Payment deleted sucessfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching all payments."));

		}
    }

}
