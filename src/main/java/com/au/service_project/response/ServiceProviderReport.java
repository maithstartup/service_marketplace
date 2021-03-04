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


}