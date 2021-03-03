package com.au.service_project.repository;

import com.au.service_project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Optional<Customer> findCustomerByEmailId(String s);

}
