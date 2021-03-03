package com.au.service_project.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import com.au.service_project.entity.Category;
import com.au.service_project.entity.Customer;
import com.au.service_project.impl.CategoryServiceImpl;
import com.au.service_project.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerServiceImpl customerService;
	
	@Mock
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Nested 
	class AddCategoryTest { 
	
	@Test
	void testAddCustomer_Success() {
		Customer customer= new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("abc");
		customer.setLastName("abbas");
		customer.setAddress(null);
		customer.setEmailId("abc@gmail.com");
		customer.setPassword("abbas@baba");
		customer.setPhoneNum("1234567890");
		customer.setCustomerPic(null);
		Mockito.when(customerService.addCustomer(Mockito.anyObject()))
        .thenReturn(customer);
		String plainPassword = customer.getPassword(); 
		String encryptedPassword = bCryptPasswordEncoder.encode(plainPassword);
		Customer response = customerService.addCustomer(customer);
		
		Assertions.assertNotNull(response); 
		Assertions.assertDoesNotThrow(() -> customerController.addCustomer(customer));
		
		
	}
	@Test
	void testAddCustomer_Failed() {
		Customer customer= new Customer();
		
		Assertions.assertDoesNotThrow(() -> customerController.addCustomer(customer));
		
	}
	
	
	@Nested
	class HandleImagePostTest{
		@Test
		void testHandleImagePost_Success() {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
			
			MultipartFile file = null;
			Mockito.when(customerService.saveImageFile(Mockito.anyInt(), Mockito.any()))
	        .thenReturn(customer);
			Assertions.assertDoesNotThrow(() -> customerController.handleImagePost(1,file));
		}
		
		
		@Test
		void testGetCategoryAllName_Failed() {
			Assertions.assertDoesNotThrow(() -> customerController.handleImagePost(1,null));
				}
	}
	
}
	@Nested 
	class GetCustomerByIdTest{
		@Test
		void testGetCustomerById_Success() {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
				Mockito.when(customerService.getCustomerById(Mockito.anyInt()))
	        .thenReturn(customer);
			Customer response = customerService.getCustomerById(1);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->  customerController.getCustomerById(1));
		}
		
		
		@Test
		void testGetCategoryById_Failed() {
			Mockito.when(customerService.getCustomerById(Mockito.anyInt()))
	        .thenReturn(null);
			Customer response = customerService.getCustomerById(1);
			Assertions.assertDoesNotThrow(() ->  customerController.getCustomerById(1));
				
		}
	}
	@Nested 
	class GetCustomerByEmailTest{
		@Test
		void testGetCustomerById_Success() {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
			
			Mockito.when(customerService.getCustomerByEmailId(Mockito.anyString()))
	        .thenReturn(customer);
			Customer response = customerService.getCustomerByEmailId("abc@gmail.com");
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->  customerController.getCustomerById("abc@gmail.com"));
		}
		
		
		@Test
		void testGetCategoryById_Failed() {
			Mockito.when(customerService.getCustomerByEmailId(Mockito.anyString()))
	        .thenReturn(null);
			Customer response = customerService.getCustomerByEmailId("abc@gmail.com");
			Assertions.assertDoesNotThrow(() ->  customerController.getCustomerById("abc@gmail.com"));
					
		}
	}


	
	/////////////////////////////////////////////

	@Nested
	class GetCustomerBillingTest{
		@Test
		void testGetCustomerBilling_Success() throws IOException {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
			
			HttpServletResponse HSR = null;
			
			Mockito.when(customerService.getCustomerById(Mockito.anyInt()))
	        .thenReturn(customer);
			Assertions.assertDoesNotThrow(() ->   customerController.getCustomerBilling(1));
		}
		
		
		@Test
		void testGetCustomerBilling_Failed() {
			Assertions.assertDoesNotThrow(() ->   customerController.getCustomerBilling(10));
		}
	}
	
	@Nested
	class GetCustomerTransactionTest{
		@Test
		void testGetCustomerTransaction_Success() throws IOException {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
			
			
			Mockito.when(customerService.getCustomerById(Mockito.anyInt()))
	        .thenReturn(customer);
			Assertions.assertDoesNotThrow(() ->   customerController.getCustomerTransaction(1));
		}
		
		
		@Test
		void testGetCustomerTransaction_Failed() {
			Assertions.assertDoesNotThrow(() ->   customerController.getCustomerTransaction(10));
		}
	}
	
	@Nested
	class RenderImageFromDBTest{
		@Test
		void testRenderImageFromDB_Success() throws IOException {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
			
			HttpServletResponse HSR = null;
			
			Mockito.when(customerService.getCustomerById(Mockito.anyInt()))
	        .thenReturn(customer);
			String response = customerController.renderImageFromDB(1,HSR);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->   customerController.renderImageFromDB(1,HSR));
		}
		
		
		@Test
		void testRenderImageFromDB_Failed() {
			Assertions.assertDoesNotThrow(() ->   customerController.renderImageFromDB(1,null));
		}
	}
	
	
	
	
	
	
	@Nested
	class UpdateCustomerByIdTest{
		@Test
		void testUpdateCustomerById_Success() {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
			
			Mockito.when(customerService.updateCustomerById(Mockito.anyInt(), Mockito.anyObject()))
	        .thenReturn(customer);
			ResponseEntity<Object> response = customerController.updateCustomerById(1,customer);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->   customerController.updateCustomerById(1,customer));
		}
		
		
		@Test
		void testUpdateCustomerById_Failed() {
			Assertions.assertDoesNotThrow(() ->   customerController.updateCustomerById(1,null));
		}
	}
	
	
	
	
	
	@Nested
	class DeleteCustomerByIdTest{
		@Test
		void testDeleteCategoryById_Success() {
			Customer customer= new Customer();
			customer.setCustomerId(1);
			customer.setFirstName("abc");
			customer.setLastName("abbas");
			customer.setAddress(null);
			customer.setEmailId("abc@gmail.com");
			customer.setPassword("abbas@baba");
			customer.setPhoneNum("1234567890");
			customer.setCustomerPic(null);
			
			Mockito.when(customerService.deleteCustomerById(Mockito.anyInt()))
	        .thenReturn("Deleted the Category");
			ResponseEntity<Object> response = customerController.deleteCustomerById(1);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->   customerController.deleteCustomerById(1));
		}
		
		
		@Test
		void testDeleteCustomeryById_Failed() {
			Mockito.when(customerService.deleteCustomerById(Mockito.anyInt()))
	        .thenReturn(null);
			ResponseEntity<Object> response = customerController.deleteCustomerById(1);
			Assertions.assertDoesNotThrow(() ->   customerController.deleteCustomerById(1));
		}
	}
	
	

}
