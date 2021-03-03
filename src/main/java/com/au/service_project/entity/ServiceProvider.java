package com.au.service_project.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceProviderId;

    private String companyName;

    private String ownerName;

    @Column (unique = true)
    private String emailId;

    @Column (unique = true)
    private String phoneNum;

    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_address_id", referencedColumnName = "addressId")
	@JsonIgnore
    private Address serviceAddress;

    private Double spRating;//Service Provider Rating

    @ManyToMany
    @JoinTable(name = "ServiceProvider_Category", joinColumns = {@JoinColumn(referencedColumnName = "serviceProviderId")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "categoryId")})
	@JsonIgnore
    private Set<Category> category;

//    @JsonIgnore
    @OneToMany(mappedBy = "serviceProviderId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Service> services;

    @OneToMany(mappedBy = "serviceProviderId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Billing> billings;
    
    @Lob
    @Column(name="serviceProviderPic")
	@JsonIgnore
    private Byte[] serviceProviderPic;

    //Getters and setters
    
    
	public Integer getServiceProviderId() {
		return serviceProviderId;
	} 

	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(Address serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	
	public Double getSpRating() {
		return spRating;
	}

	public void setSpRating(Double spRating) {
		this.spRating = spRating;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Set<Billing> getBillings() {
		return billings;
	}

	public void setBillings(Set<Billing> billings) {
		this.billings = billings;
	}

	public Byte[] getServiceProviderPic() {
		return serviceProviderPic;
	}

	public void setServiceProviderPic(Byte[] serviceProviderPic) {
		this.serviceProviderPic = serviceProviderPic;
	}

//
    
    
    
	
  
}