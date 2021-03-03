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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.au.service_project.entity.Customer;
import com.au.service_project.entity.Customer;
import com.au.service_project.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Mock
	CustomerRepository customerRepository;

	@Mock
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Nested 
	class AddCustomerTest {
		
	@Test
	void testAddCustomer_Success() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("abc company");
		customer.setEmailId("abc@gmail.com");
		customer.setLastName("xyz");
		customer.setPhoneNum("1234567895");
		customer.setPassword("ggfhg");
		
			Mockito.when(customerRepository.save(Mockito.anyObject()))
	          .thenReturn(customer);
			
			Assertions.assertDoesNotThrow(() -> customerService.addCustomer(customer));
		}
	
	
	@Test
	void testAddCustomer_Failed() throws Exception{
	
			Customer customer = new Customer();
			
			Assertions.assertThrows(Exception.class,() -> customerService.addCustomer(null));
			
		}
		
	}
	
	@Nested
	class SaveImageFileTest {
		
		@Test
		void testSaveImageFile_Success() {
			Customer customer=new Customer();
			customer.setCustomerId(1);
			Optional<Customer> customer2 = Optional.of(customer);
			byte[] byteObjects = null;
			customer.setCustomerPic(byteObjects);
			
			Mockito.when(customerRepository.findById(Mockito.anyInt()))
	          .thenReturn(customer2);
				
			Mockito.when(customerRepository.save(Mockito.anyObject()))
	          .thenReturn(customer);
			Assertions.assertDoesNotThrow(() -> customerService.saveImageFile(1,null));
				
		}
	
		@Test
		void testGetCustomer_Failed() {
				Assertions.assertDoesNotThrow(() -> customerService.saveImageFile(1,null));
			}
		
	}
	
	
	
	@Nested 
	class GetCustomerByIdTest {
		
	@Test
	void testGetCustomer_Success() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("abc company");
		customer.setEmailId("abc@gmail.com");
		customer.setLastName("xyz");
		customer.setPhoneNum("1234567895");
		customer.setPassword("ggfhg");
		Optional<Customer> customer2 = Optional.of(customer);
		
			
			Mockito.when(customerRepository.findById(Mockito.anyInt()))
	          .thenReturn(customer2);
			
			Assertions.assertDoesNotThrow(() -> customerService.getCustomerById(1));
		}
	
	
	@Test
	void testGetCustomer_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> customerService.getCustomerById(10));
			
		}
		
	}
	
	@Nested 
	class GetCustomerByEmailIdTest {
		
	@Test
	void testGetCustomer_Success() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("abc company");
		customer.setEmailId("abc@gmail.com");
		customer.setLastName("xyz");
		customer.setPhoneNum("1234567895");
		customer.setPassword("ggfhg");
		Optional<Customer> customer2 = Optional.of(customer);
		
			
			Mockito.when(customerRepository.findCustomerByEmailId(Mockito.anyString()))
	          .thenReturn(customer2);
			
			Assertions.assertDoesNotThrow(() -> customerService.getCustomerByEmailId("abc@gmail.com"));
		}
	
	
	@Test
	void testGetCustomer_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> customerService.getCustomerByEmailId("abc@gmail.com"));
			
		}
		
	}
	
	
	
	
	
	
	@Nested 
	class TestUpdateCustomerById {
		
	@Test
	void testUpdateCustomer_Success() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("abc company");
		customer.setEmailId("abc@gmail.com");
		customer.setLastName("xyz");
		customer.setPhoneNum("1234567895");
		customer.setPassword("ggfhg");
		Optional<Customer> customer2 = Optional.of(customer);
		Customer customer3 = customer2.get();
        
			
			Mockito.when(customerRepository.findById(Mockito.anyInt()))
	          .thenReturn(customer2);
			Mockito.when(customerRepository.save(Mockito.anyObject()))
	          .thenReturn(customer);
			   
			
			Assertions.assertDoesNotThrow(() -> customerService.updateCustomerById(1,customer));
		}
	
	@Test
	void testUpdateCustomer_Success2() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("abc company");
		customer.setEmailId("abc@gmail.com");
		customer.setLastName("xyz");
		customer.setPhoneNum("1234567895");
		customer.setPassword(null);
		Optional<Customer> customer2 = Optional.of(customer);
		Customer customer3 = customer2.get();
        
			
			Mockito.when(customerRepository.findById(Mockito.anyInt()))
	          .thenReturn(customer2);
			Mockito.when(customerRepository.save(Mockito.anyObject()))
	          .thenReturn(customer);
			   
			
			Assertions.assertDoesNotThrow(() -> customerService.updateCustomerById(1,customer));
		}
	
	
	
	@Test
	void testUpdateCustomer_Failed() {
	
			Customer customer = new Customer();
			
			Assertions.assertDoesNotThrow(() -> customerService.updateCustomerById(10,customer));
			
		}
		
	}
	
	
	@Nested 
	class DeleteCustomerTest {
		
	@Test
	void testDeleteCustomer_Success() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("abc company");
		customer.setEmailId("abc@gmail.com");
		customer.setLastName("xyz");
		customer.setPhoneNum("1234567895");
		customer.setPassword("ggfhg");
		
		Optional<Customer> customer2 = Optional.of(customer);
		
			
			Mockito.when(customerRepository.findById(1))
	          .thenReturn(customer2);
			Mockito.doNothing().when(customerRepository).deleteById(1);
			
			Assertions.assertDoesNotThrow(() -> customerService.deleteCustomerById(1));
		}
	
	
	@Test
	void testDeleteCustomer_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> customerService.deleteCustomerById(1));
			
		}
		
	}
	
	@Nested 
	class GetEncryptedPasswordTest {
	
	@Test
	void TestgetEncryptedPassword() {
	
			
			Assertions.assertDoesNotThrow(() -> bCryptPasswordEncoder.encode("xyz"));
			
		}
		
	}
	
	
}
	
