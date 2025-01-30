package com.sharma.finance.sharmaFinance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "contact_info", nullable = false, length = 255)
    private String contactInfo;

    @ManyToOne
    @JoinColumn(name = "responsible_id", referencedColumnName = "responsible_id", nullable = false)
    private ResponsiblePerson responsiblePerson;

    @Column(name = "status", length = 50)
    private String status = "Active";

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    
    public Member() {}

	public Member(int memberId, String name, String contactInfo, /* int responsibleId, */ String status) {
        this.memberId = memberId;
        this.name = name;
        this.contactInfo = contactInfo;
        //this.responsibleId = responsibleId;
        this.status = status;
    }

	// Getters and Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ResponsiblePerson getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(ResponsiblePerson responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
		return "Member [memberId=" + memberId + ", name=" + name + ", contactInfo=" + contactInfo
				+ ", responsiblePerson=" + responsiblePerson + ", status=" + status + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}
    
    
}
