package com.sharma.finance.sharmaFinance.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sharma.finance.sharmaFinance.model.Payment;

@Service
public class PaymentService {
	
	private static List<Payment> payments = new ArrayList<>();
    static {
        payments.add(new Payment(1, LocalDate.of(2025, 1, 16), new BigDecimal(15.50), new BigDecimal(50.00)));
        payments.add(new Payment(1, LocalDate.of(2025, 1, 16), new BigDecimal(15.50), new BigDecimal(50.00)));
         }
}
