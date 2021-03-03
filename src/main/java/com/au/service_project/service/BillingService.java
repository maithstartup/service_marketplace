package com.au.service_project.service;

import com.au.service_project.entity.Billing;

public interface BillingService {

    public Billing addBilling(Billing billing);

    public Billing getBillingById(Integer id);

    public Billing updateBillingById(Integer id, Billing billing);

    public String deleteBillingById(Integer id);
    
  //query
    
  	public Float getBillingCostById(Integer billingId);



}