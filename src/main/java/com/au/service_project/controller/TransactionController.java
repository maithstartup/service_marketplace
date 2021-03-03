package com.au.service_project.controller;

import com.au.service_project.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.au.service_project.entity.Transaction;
import com.au.service_project.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController { 

    @Autowired
    TransactionService transactionService;

    @Autowired
    BillingService billingService;

    @PostMapping("")
    public ResponseEntity<Object> addTransaction(@RequestBody Transaction transaction)
    {

        Transaction response = transactionService.addTransaction(transaction);
        billingService.getBillingCostById(transaction.getBillingId());

        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to create", HttpStatus.BAD_REQUEST);

    }
  
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTransaction(@PathVariable Integer id){
        Transaction response = transactionService.getTransactionById(id);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("No Bills Available", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> putTransaction(@PathVariable Integer id, @RequestBody Transaction transaction) {
        Transaction response = transactionService.updateTransactionById(id , transaction);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Could not update Transaction Details", HttpStatus.BAD_REQUEST);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTransaction(@PathVariable Integer id){
        String response=transactionService.deleteTransactionById(id);

        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Could not delete Transaction details", HttpStatus.BAD_REQUEST);

    }
}
