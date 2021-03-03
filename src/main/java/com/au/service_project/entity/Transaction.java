package com.au.service_project.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    private Integer serviceId;

    private Integer billingId;

    private Integer customerId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String status;

    private Float transactionRating;

    private Float transactionAmount;
    
    private Float originalCost;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getBillingId() {
		return billingId;
	}

	public void setBillingId(Integer billingId) {
		this.billingId = billingId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getTransactionRating() {
		return transactionRating;
	}

	public void setTransactionRating(Float transactionRating) {
		this.transactionRating = transactionRating;
	}

	public Float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Float getOriginalCost() {
		return originalCost;
	}

	public void setOriginalCost(Float originalCost) {
		this.originalCost = originalCost;
	}


	
		
	
	//getters and setters
    
    

}
