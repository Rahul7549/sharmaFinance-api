package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.Payment;
import com.sharma.finance.sharmaFinance.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/payments")
	public ResponseEntity<?> findAllPayment(){
		return paymentService.findAllPayment();
	}
	
	@GetMapping("/payments/{paymentId}")
	public ResponseEntity<?> findPaymentById(@PathVariable Long paymentId){
		return paymentService.findPaymentById(paymentId);
	}
	
	
	@PostMapping("/payments")
	public ResponseEntity<?> createNewPayment(@RequestBody Payment newPayment){
		System.out.println(newPayment);
		return paymentService.createPayments(newPayment);
	}
	
	
	@PutMapping("/payments/{paymentId}")
	public ResponseEntity<?> updatePayment(@PathVariable Long paymentId, @RequestBody Payment newPayment){
		return paymentService.updatePayment(paymentId, newPayment);
	}
	
	@DeleteMapping("/payment/{paymentId}")
	public ResponseEntity<?> deletePayment(@PathVariable Long paymentId){
		return paymentService.deletePaymenstById(paymentId);
	}
	
}
