package com.sharma.finance.sharmaFinance.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.LoanPayment;
import com.sharma.finance.sharmaFinance.service.LoanPaymentService;

import jakarta.validation.Valid;

@RestController("loanPayment")
public class LoanPaymentController {

	private static final Logger logger = LoggerFactory.getLogger(LoanPaymentController.class);

	@Autowired
	LoanPaymentService loanPaymentService;

	@GetMapping("/loan-payments")
	public ResponseEntity<List<LoanPayment>> findAllLoan() {
		return loanPaymentService.findAllLoanPayment();
	}

	@GetMapping("/loan-payments/{paymentId}")
	public ResponseEntity<LoanPayment> findLoanPaymentById(@PathVariable Long paymentId) {
		return loanPaymentService.findLoanPaymentById(paymentId);
	}

	@GetMapping("/all-loan-payments/{paymentId}")
	public ResponseEntity<?> findAllLoanPaymentById(@PathVariable Long paymentId) {
		return loanPaymentService.findAllLoanPaymentById(paymentId);
	}

	@PostMapping("/loan-payments")
	public ResponseEntity<?> createNewLoanPayment(@RequestBody LoanPayment newLoanPayment
	/* , BindingResult result */) {

//	Map<String, String> validationErrors = loanPaymentService.validateLoanPayment(result);
//
//	if (!validationErrors.isEmpty()) {
//
//		return ResponseEntity.badRequest().body(validationErrors);
//
//	}

		try {

			LoanPayment savedLoanPayment = loanPaymentService.saveLoanPayment(newLoanPayment);

			return ResponseEntity.status(HttpStatus.CREATED).body(savedLoanPayment);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)

					.body(Map.of("error", "An unexpected error occurred while saving the loan payment."));

		}

	}

	@PutMapping("loan-payments/{paymentId}")
	public ResponseEntity<?> updateLoanPayment(@PathVariable Long paymentId, @RequestBody LoanPayment request) {

//		Map<String, String> validationErrors = loanPaymentService.validateLoanPayment(result);
//
//		if (!validationErrors.isEmpty()) {
//
//			return ResponseEntity.badRequest().body(validationErrors);
//
//		}
//		
		try {
			logger.info("Updating LoanPayment with ID: {}", paymentId);
			return loanPaymentService.updateLoanPayment(paymentId, request);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)

					.body(Map.of("error", "An unexpected error occurred while saving the loan payment."));

		}

	}

	@DeleteMapping("loan-payments/{paymentId}")
	public ResponseEntity<String> deleteLoanPayment(@PathVariable Long paymentId) {
		logger.info("Request to delete LoanPayment with ID: {}", paymentId);

		loanPaymentService.deleteLoanPayment(paymentId);

		return ResponseEntity.ok("LoanPayment deleted successfully");
	}



}
