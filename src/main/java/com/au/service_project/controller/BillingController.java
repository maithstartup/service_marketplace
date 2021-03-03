package com.au.service_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.service_project.entity.Billing;
import com.au.service_project.service.BillingService;


@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired 
    BillingService billingService;

    @PostMapping("")
    public ResponseEntity<Object> addBilling(@RequestBody Billing billing)
    {

        Billing response = billingService.addBilling(billing);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("not able to create", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBilling(@PathVariable Integer id){
        Billing response = billingService.getBillingById(id);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("No Bills Available", HttpStatus.BAD_REQUEST);

    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Object> putBilling(@PathVariable Integer id, @RequestBody Billing billing) {
        Billing response = billingService.updateBillingById(id , billing);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Could not update Billing Details", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBilling(@PathVariable Integer id){
        String response=billingService.deleteBillingById(id);

        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Could not delete Billing details", HttpStatus.BAD_REQUEST);

    }

// Queries
    
    @GetMapping("/billingcost/{billingId}")
    public ResponseEntity<Object> getBillingCostById(@PathVariable("billingId") Integer billingId){
    	Float billingCost = billingService.getBillingCostById(billingId);
    	if(billingCost != null)
            return new ResponseEntity<>(billingCost, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to get billing cost", HttpStatus.BAD_REQUEST);
    }







}