package com.sharma.finance.sharmaFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharma.finance.sharmaFinance.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{

}
