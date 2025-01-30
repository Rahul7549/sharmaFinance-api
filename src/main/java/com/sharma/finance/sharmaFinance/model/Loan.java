package com.sharma.finance.sharmaFinance.model;

//import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false)
    private Member member;

    @Column(name = "loan_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal loanAmount;

    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal interestRate = new BigDecimal("1.0"); // Default value of 1.0

    @Column(name = "loan_balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal loanBalance;

    @Column(name = "loan_status", length = 50)
    private String loanStatus = "Approved"; // Default value of "Approved"

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    
    public Loan() {}

    public Loan(int memberId, BigDecimal loanAmount, BigDecimal interestRate, BigDecimal loanBalance, 
    		String   loanStatus) {
        this.loanId = memberId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanBalance = loanBalance;
        this.loanStatus = loanStatus;
    }
	// Getters and Setters
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", member=" + member + ", loanAmount=" + loanAmount + ", interestRate="
				+ interestRate + ", loanBalance=" + loanBalance + ", loanStatus=" + loanStatus + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + "]";
	}
    
    
}
