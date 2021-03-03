package com.au.service_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.au.service_project.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction ,Integer>{

	

}