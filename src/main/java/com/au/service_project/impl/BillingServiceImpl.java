package com.au.service_project.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.service_project.entity.Billing;
import com.au.service_project.repository.BillingRepository;
import com.au.service_project.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService{
    @Autowired
    BillingRepository billingRepository;

    @Override
    public Billing addBilling(Billing billing){

        try {
            billingRepository.save(billing);
            return billing;
        }
        catch(Exception e)
        {
            return null;
        }

    }

    @Override
    public Billing getBillingById(Integer id) {
        Optional<Billing> billing = billingRepository.findById(id);
        if(billing.isPresent()) {
            return billing.get();
        }
        return null;
    }

    @Override
    public Billing updateBillingById(Integer id, Billing billing) {
        Optional<Billing> billing2 = billingRepository.findById(id);
        if(billing2.isPresent()) {

        	Billing billing3 = billing2.get();
            billing3.setGst((billing.getGst()!=null)? billing.getGst():billing3.getGst() );
           

            return billingRepository.save(billing3);

        }
        return null;
    }

    @Override
    public String deleteBillingById(Integer id) {
        Optional<Billing> billing = billingRepository.findById(id);
        if(billing.isPresent()) {
            billingRepository.deleteById(id);
            return "Deleted the Bill";
        }

        return "No such Billing available";

    }

    @Override
	public Float getBillingCostById(Integer billingId) {
		Optional<Billing> billing = billingRepository.findById(billingId);
		Float billingCost = billingRepository.getBillingCostById(billingId);
		Float originalCost = billingRepository.getOriginalCostById(billingId);
        if(billing.isPresent()) {
        	Billing billing2 = billing.get();
        	billing2.setCost(billingCost);
        	Float cost = billing2.getCost();
        	billing2.setTotalCost(cost*(100+billing2.getGst())/100);
        	billing2.setOriginalCost(originalCost);
        	billingRepository.save(billing2);
        	return billingCost;
        }
        return null;

	}



    


}