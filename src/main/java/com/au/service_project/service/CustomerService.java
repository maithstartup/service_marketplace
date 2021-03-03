package com.au.service_project.service;

import com.au.service_project.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerService {

    public Customer addCustomer(Customer customer);

    public Customer saveImageFile(Integer customerId, MultipartFile file);

    public Customer getCustomerById(Integer customerId);

    public Customer getCustomerByEmailId(String emailId);

	public Customer updateCustomerById(Integer customerId, Customer customer);

	public String deleteCustomerById(Integer customerId);
	
	
}
