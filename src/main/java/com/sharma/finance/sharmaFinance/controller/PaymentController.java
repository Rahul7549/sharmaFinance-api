package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.Payment;
import com.sharma.finance.sharmaFinance.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/payments")
	public List<Payment> findAllPayment(){
		return paymentService.findAllPayment();
	}
	
}
