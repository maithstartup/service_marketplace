package com.au.service_project.controller;

import com.au.service_project.entity.Address;
import com.au.service_project.entity.Customer;
import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.service.AddressService;
import com.au.service_project.service.CustomerService;
import com.au.service_project.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceProviderService serviceProviderService;



    @PostMapping("/customer/{id}")
    public ResponseEntity<Object> addCustomerAddress(@RequestBody Address address, @PathVariable("id") Integer id){

        Customer customer =customerService.getCustomerById(id);
        if(customer != null)
        {
            customer.setAddress(address);
            customerService.addCustomer(customer);
            Customer customer1 = customerService.getCustomerById(id);
            Address responseAddress = customer1.getAddress();


            return new ResponseEntity<>(responseAddress, HttpStatus.OK);

        }

        return new ResponseEntity<>("not able to add", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/serviceprovider/{id}")
    public ResponseEntity<Object> addServiceProviderAddress(@RequestBody Address address, @PathVariable("id") Integer id){

        ServiceProvider serviceProvider =serviceProviderService.getServiceProviderById(id);
        if(serviceProvider != null)
        {
            serviceProvider.setServiceAddress(address);
            serviceProviderService.addServiceProvider(serviceProvider);
            ServiceProvider serviceProvider1 = serviceProviderService.getServiceProviderById(id);
            Address responseAddress = serviceProvider1.getServiceAddress();


            return new ResponseEntity<>(responseAddress, HttpStatus.OK);


        }

        return new ResponseEntity<>("not able to add", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Object> updateAddressById(@PathVariable("addressId") Integer addressId, @RequestBody Address address){
        Address addressResponse = addressService.updateAddressById(addressId,address);
        if(addressResponse != null)
            return new ResponseEntity<>(addressResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to update customer", HttpStatus.BAD_REQUEST);

    }



}
