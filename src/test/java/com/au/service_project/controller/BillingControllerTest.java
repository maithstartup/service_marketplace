package com.au.service_project.controller;


import java.util.Date;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.au.service_project.entity.Billing;
import com.au.service_project.entity.Transaction;
import com.au.service_project.impl.BillingServiceImpl;

@ExtendWith(MockitoExtension.class)
class BillingControllerTest {

	@InjectMocks
	BillingController billingController;
	
	@Mock
	BillingServiceImpl billingService; 
	
	@Nested 
	class AddBillingTest {
		
	@Test 
	void testAddBilling_Success() {
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		
			
			Mockito.when(billingService.addBilling(Mockito.anyObject()))
	          .thenReturn(billing);
			ResponseEntity<Object> response = billingController.addBilling(billing);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> billingController.addBilling(billing));
		}
	
	
	@Test
	void testAddBilling_Failed() {
	
			Billing billing = new Billing();
			Mockito.when(billingService.addBilling(Mockito.anyObject()))
	          .thenReturn(null);
			ResponseEntity<Object> response = billingController.addBilling(billing);
			
			Assertions.assertNotNull(response);
		}
		
	}

	@Nested 
	class GetBillingTest {
		
	@Test
	void testGetBilling_Success(){
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		
			 
			Mockito.when(billingService.getBillingById(Mockito.anyInt()))
	          .thenReturn(billing);
			ResponseEntity<Object> response = billingController.getBilling(1);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> billingController.getBilling(1));
		}
	
	
	@Test
	void testAddBilling_Failed() {
	
			Billing billing = new Billing();
			Mockito.when(billingService.getBillingById(Mockito.anyInt()))
	          .thenReturn(null);
			ResponseEntity<Object> response = billingController.getBilling(1);
			
			Assertions.assertNotNull(response);
		}
		
	}

	@Nested 
	class PutBillingTest { 
		
	@Test
	void testPutBilling_Success(){
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		
			
			Mockito.when(billingService.updateBillingById(Mockito.anyInt(), Mockito.anyObject()))
	          .thenReturn(billing);
			ResponseEntity<Object> response = billingController.putBilling(1,billing);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> billingController.putBilling(1,billing));
		}
	
	
	@Test
	void testPutBilling_Failed() {
	
			Billing billing = new Billing();
			Mockito.when(billingService.updateBillingById(Mockito.anyInt(), Mockito.anyObject()))
	          .thenReturn(null);
			ResponseEntity<Object> response = billingController.putBilling(1,billing);
			
			Assertions.assertNotNull(response);
		}
		
	}

	
	@Nested 
	class DeleteBillingTest {
		
	@Test
	void testDeleteBilling_Success(){
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
	
			
			Mockito.when(billingService.deleteBillingById(Mockito.anyInt()))
	          .thenReturn("Deleted the Bill");
			ResponseEntity<Object> response = billingController.deleteBilling(1);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> billingController.deleteBilling(1));
		}
	
	
	@Test
	void testDeleteBilling_Failed() {
	
			Billing billing = new Billing();
			Mockito.when(billingService.deleteBillingById(Mockito.anyInt()))
	          .thenReturn(null);
			ResponseEntity<Object> response = billingController.deleteBilling(1);
			
			Assertions.assertNotNull(response);
		}
		
	}


	@Nested 
	class GetBillingCostTest {
		
	@Test
	void testGetBillingCost_Success(){
			Billing billing = new Billing();
			billing.setBillingId(1);
			billing.setCost((float) 80);
			billing.setCustomerId(1);
			billing.setGst(5);
			billing.setOriginalCost((float) 100);
			billing.setServiceProviderId(1);
			billing.setTotalCost((float) 84);
			billing.setTransactions(null);
	
			 
			Mockito.when(billingService.getBillingCostById(Mockito.anyInt()))
	          .thenReturn((float) 80);
			ResponseEntity<Object> response = billingController.getBillingCostById(1);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> billingController.getBillingCostById(1));
		}
	
	
	@Test
	void testGetBillingCost_Failed() {
	
			Billing billing = new Billing();
			Mockito.when(billingService.getBillingCostById(Mockito.anyInt()))
	          .thenReturn(null);
			ResponseEntity<Object> response = billingController.getBillingCostById(1);
			
			Assertions.assertNotNull(response);
		}
		
	}

	
}
