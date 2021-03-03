package com.au.service_project.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.au.service_project.entity.Service;
import com.au.service_project.entity.Address;
import com.au.service_project.repository.AddressRepository;
import com.au.service_project.service.ServiceService;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {

	@InjectMocks
	AddressServiceImpl addressService;
	
	@Mock
	AddressRepository addressRepository;

	@Mock
	ServiceService serviceService;

	@Nested 
	class AddAddressTest {
		
	@Test
	void testAddAddress_Success() {
		Address address=new Address();
		address.setAddressId(123);
		address.setArea("abc");
		address.setCity("hyd");
		address.setCountry("abc");
		address.setState("ts");
		address.setPincode(522001);
		address.setHouseAddress("add");
		address.setAddressId(null);
		address.setServiceProvider(null);
	
		Service service = new Service();
		service.setDiscountAvailability(true);
		service.setDiscount((float)5);
		service.getDiscount();
		
		
			
			Mockito.when(addressRepository.save(Mockito.anyObject()))
	          .thenReturn(address);
			
			Mockito.when(serviceService.getServiceById(Mockito.anyInt()))
	          .thenReturn(service);
		
			
			
			Assertions.assertDoesNotThrow(() -> addressService.addAddress(address));
		}
		
	
	@Test
	void testAddAddress_Failed() throws Exception{
	
			Address address = new Address();
			
			Assertions.assertThrows(Exception.class,() -> addressService.addAddress(null));
			
		}
		
	}
	
	
	
	@Nested 
	class TestUpdateAddressById {
		
	@Test
	void testUpdateAddress_Success() {
		Address address=new Address();
		address.setAddressId(123);
		address.setArea("abc");
		address.setCity("hyd");
		address.setCountry("abc");
		address.setState("ts");
		address.setPincode(522001);
		address.setHouseAddress("add");
		address.setAddressId(null);
		address.setServiceProvider(null);
		
		Optional<Address> address2 = Optional.of(address);
		Address address3 = address2.get();
       
			
			Mockito.when(addressRepository.findById(Mockito.anyInt()))
	          .thenReturn(address2);
			Mockito.when(addressRepository.save(Mockito.anyObject()))
	          .thenReturn(address);
			   
			
			Assertions.assertDoesNotThrow(() -> addressService.updateAddressById(1,address));
		}
	
	
	
	@Test
	void testUpdateAddress_Failed() {
	
			Address address = new Address();
			
			Assertions.assertDoesNotThrow(() -> addressService.updateAddressById(10,address));
			
		}
		
	}
	
	
	
}
