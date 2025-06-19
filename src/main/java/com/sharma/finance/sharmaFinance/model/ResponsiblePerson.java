package com.sharma.finance.sharmaFinance.model;

//import javax.persistence.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity(name = "admins")
public class ResponsiblePerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responsible_id")
    private int responsibleId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "contact_info", nullable = false, length = 255)
    private String contactInfo;

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    
    //@OneToMany
    //@JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false)
    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members;
    
    public ResponsiblePerson() {}

    public ResponsiblePerson(int responsibleId, String name, String contactInfo) {
        this.responsibleId = responsibleId;
        this.name = name;
        this.contactInfo = contactInfo;
    }


	// Getters and Setters
    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
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
    

	public List<Member> getMembers() {
		return members;
	}

//	public void setMembers(List<Member> members) {
//		this.members = members;
//	}

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
		return "ResponsiblePerson [responsibleId=" + responsibleId + ", name=" + name + ", contactInfo=" + contactInfo
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
    
}

