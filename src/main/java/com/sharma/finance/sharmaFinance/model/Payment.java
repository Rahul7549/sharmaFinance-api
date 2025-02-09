package com.sharma.finance.sharmaFinance.model;

//import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.ComponentScan;
import jakarta.persistence.*;

@ComponentScan
@Entity(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false)
    private Member member;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount_paid", nullable = false, precision = 10, scale = 2)
    private BigDecimal amountPaid;

    @Column(name = "fine", precision = 10, scale = 2)
    private BigDecimal fine = BigDecimal.ZERO;

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    public Payment() {}
    
//    public Payment(int memberId, LocalDate paymentDate, BigDecimal amountPaid, BigDecimal fine) {
//        this.paymentId = memberId;
//        this.paymentDate = paymentDate;
//        this.amountPaid = amountPaid;
//        this.fine = fine;
//    }

	// Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

//    public Member getMember() {
//        return member;
//    }
//
    public void setMember(Member member) {
        this.member = member;
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

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
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

    @PrePersist
    protected void onCreate() {
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
    
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", member=" + member + ", paymentDate=" + paymentDate
				+ ", amountPaid=" + amountPaid + ", fine=" + fine + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}
}
