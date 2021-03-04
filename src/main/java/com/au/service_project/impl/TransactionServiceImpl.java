package com.au.service_project.impl;

import java.util.Date;
import java.util.Optional;

import com.au.service_project.entity.Service;
import com.au.service_project.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;


import com.au.service_project.entity.Transaction;
import com.au.service_project.repository.TransactionRepository;
import com.au.service_project.service.TransactionService;

@org.springframework.stereotype.Service
public class TransactionServiceImpl  implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ServiceService serviceService;



    public Transaction addTransaction(Transaction transaction){

        try {
            Date date = new Date();
            transaction.setDate(date);
            Integer serviceId = transaction.getServiceId();
            
            Service service = serviceService.getServiceById(serviceId);
            Float cost = service.getCost();
            transaction.setOriginalCost(cost);
            if(service.getDiscountAvailability())
            {
             cost = (cost*(100-service.getDiscount()))/100;
            }
            transaction.setTransactionAmount(cost);
           
            
            transactionRepository.save(transaction);
            return transaction;
        }
        catch(Exception e)
        {
            return null;
        }

    }

    @Override
    public Transaction getTransactionById(Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()) {
            return transaction.get();
        }
        return null;
    }

    @Override
    public Transaction updateTransactionById(Integer id, Transaction transaction) {
        Optional<Transaction> Transaction2 = transactionRepository.findById(id);
        if(Transaction2.isPresent()) {

            Transaction Transaction3 = Transaction2.get();
            Transaction3.setTransactionRating(transaction.getTransactionRating());
            Transaction3.setStatus(transaction.getStatus());

            return transactionRepository.save(Transaction3);

        }
        return null;
    }

    @Override
    public String deleteTransactionById(Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()) {
            transactionRepository.deleteById(id);
            return "Deleted the Bill";
        }

        return "No such Transaction available";

    }

	


}
