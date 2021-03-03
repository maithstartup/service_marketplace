package com.au.service_project.impl;


import com.au.service_project.entity.Customer;
import com.au.service_project.repository.CustomerRepository;
import com.au.service_project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public Customer addCustomer(Customer customer){

        try {
            customerRepository.save(customer);
            return customer;
        }
        catch(Exception e)
        {
            return null;
        }

    }
    public Customer saveImageFile(Integer customerId, MultipartFile file) {
        try {
            Optional<Customer> customerOptional  = customerRepository.findById(customerId);
            Customer customer=new Customer();
            if(customerOptional.isPresent())
            {
                customer=customerOptional.get();
            }

            byte[] byteObjects = file.getBytes();




            customer.setCustomerPic(byteObjects);
            customerRepository.save(customer);
            return customer;
        } catch (Exception e) {
            return null;
        }
    }

    public Customer getCustomerById(Integer customerId){
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    public Customer getCustomerByEmailId(String emailId){
        Optional<Customer> customer=customerRepository.findCustomerByEmailId(emailId);
        if(customer.isPresent()) {
            return customer.get();
        }
        return null;
    }
    
	@Override
	public Customer updateCustomerById(Integer customerId, Customer customer) {
		Optional<Customer> customer2 = customerRepository.findById(customerId);
        if(customer2.isPresent()) {
        	Customer customer3 = customer2.get();
        	String plainPassword = customer.getPassword();
        	if(plainPassword != null) {
                String encryptedPassword = getEncryptedPassword(plainPassword);
                customer3.setPassword(encryptedPassword);
            }
        	customer3.setFirstName(customer.getFirstName());
        	customer3.setLastName(customer.getLastName());
        	customer3.setPhoneNum(customer.getPhoneNum());
        	customer3.setEmailId(customer.getEmailId());
            return customerRepository.save(customer3);
        }
		
        return null;
	}
	@Override
	public String deleteCustomerById(Integer customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()) {
        	customerRepository.deleteById(customerId);
            return "Deleted the Customer";
        }
		
		return null;
	}
	
	
    private String getEncryptedPassword(String plainPassword) {
        return bCryptPasswordEncoder.encode(plainPassword);
    }
}
