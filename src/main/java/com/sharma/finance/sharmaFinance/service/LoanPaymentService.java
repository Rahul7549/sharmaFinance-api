package com.sharma.finance.sharmaFinance.service;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sharma.finance.sharmaFinance.exception.ResourceNotFoundException;
import com.sharma.finance.sharmaFinance.model.LoanPayment;
import com.sharma.finance.sharmaFinance.repository.LoanPaymentRepository;
import jakarta.transaction.Transactional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class LoanPaymentService {

	private static List<LoanPayment> loanPayments = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(LoanPaymentService.class);

	@Autowired
	LoanPaymentRepository loanPaymentRepository;

	public ResponseEntity<List<LoanPayment>> findAllLoanPayment() {
		// ResponseEntity<List<LoanPayment>> loanPayments=
		// loanPaymentRepository.findAll();
		List<LoanPayment> loanPayments = loanPaymentRepository.findAll();
		if (loanPayments.isEmpty()) {
			return ResponseEntity.ok(Collections.emptyList());
		}
		return ResponseEntity.ok(loanPayments);
	}

	public ResponseEntity<LoanPayment> findLoanPaymentById(Long id) {
		return loanPaymentRepository.findById(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> findAllLoanPaymentById(Long id){
	    return null;

	}

	public Map<String, String> validateLoanPayment(BindingResult result) {

		Map<String, String> errors = new HashMap<>();

		for (FieldError error : result.getFieldErrors()) {

			errors.put(error.getField(), error.getDefaultMessage());

		}

		return errors;

	}

	public LoanPayment saveLoanPayment(LoanPayment loanPayment) {

		return loanPaymentRepository.save(loanPayment);

	}

	@Transactional
	public ResponseEntity<LoanPayment> updateLoanPayment(Long paymentId, LoanPayment request) {
		LoanPayment existingPayment = loanPaymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("LoanPayment not found with ID: " + paymentId));

		existingPayment.setAmountPaid(request.getAmountPaid());
		existingPayment.setRemainingBalance(request.getRemainingBalance());
		existingPayment.setPaymentDate(LocalDate.now());

		LoanPayment updatedPayment = loanPaymentRepository.save(existingPayment);

		logger.info("Successfully updated LoanPayment with ID: {}", paymentId);

		return ResponseEntity.ok(updatedPayment);
	}

	@Transactional
	public void deleteLoanPayment(Long paymentId) {
		LoanPayment existingPayment = loanPaymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("LoanPayment not found with ID: " + paymentId));

		loanPaymentRepository.delete(existingPayment);

		logger.info("Successfully deleted LoanPayment with ID: {}", paymentId);
	}
}
