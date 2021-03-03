package com.au.service_project.response;

import com.au.service_project.entity.Billing;
import com.au.service_project.entity.Customer;
import com.au.service_project.entity.Service;
import com.au.service_project.entity.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Getter
@Setter
public class ServiceProviderReport {
    private Integer serviceProviderId;
    private Float totalRevenue;
    private Float totalRevenueGst;
    private Integer noOfBills;
    private Integer noOfServices;
    private List<Transaction> transactions;
    private Integer noOfUniquesCustomers;
    private Set<Billing> billings;
    private Set<Service> services;
    private Set<Integer> customerIds;
    private Set<Customer> customers;
	public Integer getServiceProviderId() {
		return serviceProviderId;
	}
	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	public Float getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(Float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public Float getTotalRevenueGst() {
		return totalRevenueGst;
	}
	public void setTotalRevenueGst(Float totalRevenueGst) {
		this.totalRevenueGst = totalRevenueGst;
	}
	public Integer getNoOfBills() {
		return noOfBills;
	}
	public void setNoOfBills(Integer noOfBills) {
		this.noOfBills = noOfBills;
	}
	public Integer getNoOfServices() {
		return noOfServices;
	}
	public void setNoOfServices(Integer noOfServices) {
		this.noOfServices = noOfServices;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Integer getNoOfUniquesCustomers() {
		return noOfUniquesCustomers;
	}
	public void setNoOfUniquesCustomers(Integer noOfUniquesCustomers) {
		this.noOfUniquesCustomers = noOfUniquesCustomers;
	}
	public Set<Billing> getBillings() {
		return billings;
	}
	public void setBillings(Set<Billing> billings) {
		this.billings = billings;
	}
	public Set<Service> getServices() {
		return services;
	}
	public void setServices(Set<Service> services) {
		this.services = services;
	}
	public Set<Integer> getCustomerIds() {
		return customerIds;
	}
	public void setCustomerIds(Set<Integer> customerIds) {
		this.customerIds = customerIds;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
    
    //
    


}