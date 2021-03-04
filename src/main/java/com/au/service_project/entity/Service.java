package com.au.service_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    private String serviceName;

    private Float cost;

    private Float discount;

    private Boolean discountAvailability;

    private String details;

    private Float warranty;

    private Integer serviceProviderId;

    private Integer categoryId;
    
    private Double serviceRatings;

    private Float rating;

    @OneToMany(mappedBy = "serviceId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Transaction> transactions;

    @Lob
//	@JsonIgnore
    @Column(name="servicePic")
    private byte[] servicePic;

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Boolean getDiscountAvailability() {
		return discountAvailability;
	}

	public void setDiscountAvailability(Boolean discountAvailability) {
		this.discountAvailability = discountAvailability;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Float getWarranty() {
		return warranty;
	}

	public void setWarranty(Float warranty) {
		this.warranty = warranty;
	}

	public Integer getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Double getServiceRatings() {
		return serviceRatings;
	}

	public void setServiceRatings(Double serviceRatings) {
		this.serviceRatings = serviceRatings;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public byte[] getServicePic() {
		return servicePic;
	}

	public void setServicePic(byte[] servicePic) {
		this.servicePic = servicePic;
	}

//
    
    

	

}
