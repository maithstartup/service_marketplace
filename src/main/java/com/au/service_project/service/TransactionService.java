package com.au.service_project.service;

import com.au.service_project.entity.Transaction;

public interface TransactionService {

    public Transaction addTransaction(Transaction transaction);

    public Transaction getTransactionById(Integer id);

    public Transaction updateTransactionById(Integer id, Transaction transaction);

    public String deleteTransactionById(Integer id);
    
    

}
