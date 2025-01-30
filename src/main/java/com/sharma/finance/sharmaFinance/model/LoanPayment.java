package com.sharma.finance.sharmaFinance.model;

//import javax.persistence.*;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "loan_payments")
public class LoanPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "loan_id", nullable = false)
    private Loan loan;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount_paid", nullable = false, precision = 10, scale = 2)
    private BigDecimal amountPaid;

    @Column(name = "remaining_balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal remainingBalance;

    @Column(name = "created_on", updatable = false)
    private LocalDate createdOn;

    @Column(name = "updated_on")
    private LocalDate updatedOn;
    
    public LoanPayment() {}

    public LoanPayment(int loanId, LocalDate paymentDate, BigDecimal amountPaid, BigDecimal remainingBalance) {
        this.paymentId = loanId;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
        this.remainingBalance = remainingBalance;
    }

	// Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

	@Override
	public String toString() {
		return "LoanPayment [paymentId=" + paymentId + ", loan=" + loan + ", paymentDate=" + paymentDate
				+ ", amountPaid=" + amountPaid + ", remainingBalance=" + remainingBalance + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}
    
    
}
