package com.sharma.finance.sharmaFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharma.finance.sharmaFinance.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
