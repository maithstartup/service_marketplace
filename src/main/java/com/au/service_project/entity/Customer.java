package com.au.service_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String firstName;

    private String lastName;

    @Column (unique = true)
    private String emailId;

    @Column (unique = true)
    private String phoneNum;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;


    @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnore
    private Set<Billing> billings;

    @Lob
	@JsonIgnore
    @Column(name="customerPic")
    private byte[] customerPic;
    
    
    //
    

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Set<Billing> getBillings() {
		return billings;
	}

	public void setBillings(Set<Billing> billings) {
		this.billings = billings;
	}

	public byte[] getCustomerPic() {
		return customerPic;
	}

	public void setCustomerPic(byte[] customerPic) {
		this.customerPic = customerPic;
	}
//

    

}
