package com.au.service_project.controller;
//import java.util.Date;
//import java.util.Set;

import com.au.service_project.request.AddressRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.au.service_project.entity.Address;
import com.au.service_project.entity.Customer;
import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.impl.AddressServiceImpl;
import com.au.service_project.impl.CustomerServiceImpl;

import com.au.service_project.impl.ServiceProviderImpl;

@ExtendWith(MockitoExtension.class)
class AddressControllerTest {
	@InjectMocks
	AddressController addressController;

	@Mock
	AddressServiceImpl addressService;

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerServiceImpl customerService;


	@InjectMocks
	ServiceProviderController serviceProviderController;

	@Mock
	ServiceProviderImpl serviceProviderService;

	@Nested
	class AddCustomerAddressTest{


		@Test
		void testAddCustomerAddress_Success() {
			Address address=new Address();
			address.setAddressId(123);
			address.setArea("abccolony");
			address.setCity("guntur");
			address.setCountry("India");
			address.setState("Andhra Pradesh");
			address.setPincode(522001);
			address.setHouseAddress("guntur vari thota 6th lane");
			address.setAddressId(null);
			address.setServiceProvider(null);
			Customer customer =new Customer();
			customer.setAddress(address);
			customer.setCustomerId(123);




			Mockito.when(customerService.getCustomerById(Mockito.anyInt()))
			 .thenReturn(customer);

			ResponseEntity<Object> customer1= addressController.addCustomerAddress(address,123);
			customer.setAddress(address);
            customerService.addCustomer(customer);

			Assertions.assertNotNull(customer1);
			Assertions.assertDoesNotThrow(() -> addressController.addCustomerAddress(address,123) );


		}

		@Test
		void testAddCustomerAddress_Failed() {
			Assertions.assertDoesNotThrow(() -> addressController.addCustomerAddress(null,123) );
			}


	}
	@Nested
	class AddServiceProviderAddressTest{
		@Test
		void testAddServiceProviderAddress() {
			Address address=new Address();
			address.setAddressId(123);
			address.setArea("abccolony");
			address.setCity("guntur");
			address.setCountry("India");
			address.setState("Andhra Pradesh");
			address.setPincode(522001);
			address.setHouseAddress("guntur vari thota 6th lane");
			address.setAddressId(null);
			address.setServiceProvider(null);
			AddressRequest addressRequest=new AddressRequest();
			addressRequest.setArea("abccolony");
			addressRequest.setCity("guntur");
			addressRequest.setCountry("India");
			addressRequest.setState("Andhra Pradesh");
			addressRequest.setPincode(522001);
			addressRequest.setHouseAddress("guntur vari thota 6th lane");
			ServiceProvider sp=new ServiceProvider();
			sp.setServiceProviderId(1);

			Mockito.when(serviceProviderService.getServiceProviderById(Mockito.anyInt()))
			 .thenReturn(sp);
			ServiceProvider serviceProvider= serviceProviderService.getServiceProviderById(1);
			serviceProvider.setServiceAddress(address);
			serviceProviderService.addServiceProvider(serviceProvider);
			Assertions.assertNotNull(serviceProvider);
			Assertions.assertDoesNotThrow(() -> addressController.addServiceProviderAddress(addressRequest,1) );
		}
		@Test
		void testAddServiceProviderAddress_Failed() {

			Assertions.assertDoesNotThrow(() -> addressController.addServiceProviderAddress(null,1) );
			}
	}

	@Nested
	class UpdateAddressByIdTest{
		@Test
		void testAddServiceProviderAddress() {
			Address address=new Address();
			address.setAddressId(123);
			address.setArea("abccolony");
			address.setCity("guntur");
			address.setCountry("India");
			address.setState("Andhra Pradesh");
			address.setPincode(522001);
			address.setHouseAddress("guntur vari thota 6th lane");
			address.setAddressId(null);
			address.setServiceProvider(null);
			ServiceProvider sp=new ServiceProvider();
			sp.setServiceProviderId(1);

			Mockito.when(addressService.updateAddressById(Mockito.anyInt(),Mockito.anyObject()))
			 .thenReturn(address);
			Assertions.assertDoesNotThrow(() -> addressController.updateAddressById(1,address) );
		}
		@Test
		void testAddServiceProviderAddress_Failed() {

			Assertions.assertDoesNotThrow(() -> addressController.updateAddressById(1,null) );
				}
	}





}
