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

import com.au.service_project.entity.Billing;
import com.au.service_project.entity.Transaction;
import com.au.service_project.repository.BillingRepository;

@ExtendWith(MockitoExtension.class)
class BillingServiceImplTest {
	@InjectMocks
	BillingServiceImpl billingService;
	
	@Mock
	BillingRepository billingRepository;

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
		
			
			Mockito.when(billingRepository.save(Mockito.anyObject()))
	          .thenReturn(billing);
			
			Assertions.assertDoesNotThrow(() -> billingService.addBilling(billing));
		}
	
	
	@Test
	void testAddBilling_Failed() throws Exception{
	
			Billing billing = new Billing();
			
			Assertions.assertThrows(Exception.class,() -> billingService.addBilling(billing));
			
		}
		
	}
	
	
	@Nested 
	class GetBillingByIdTest {
		
	@Test
	void testGetBilling_Success() {
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		Optional<Billing> billing2 = Optional.of(billing);
		
			
			Mockito.when(billingRepository.findById(Mockito.anyInt()))
	          .thenReturn(billing2);
			
			Assertions.assertDoesNotThrow(() -> billingService.getBillingById(1));
		}
	
	
	@Test
	void testGetBilling_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> billingService.getBillingById(10));
			
		}
		
	}
	
	
	@Nested 
	class TestUpdateBillingById {
		
	@Test
	void testUpdateBilling_Success() {
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		Optional<Billing> billing2 = Optional.of(billing);
		Billing billing3 = billing2.get();
        
			
			Mockito.when(billingRepository.findById(Mockito.anyInt()))
	          .thenReturn(billing2);
			Mockito.when(billingRepository.save(Mockito.anyObject()))
	          .thenReturn(billing);
			   
			
			Assertions.assertDoesNotThrow(() -> billingService.updateBillingById(1,billing));
		}
	
	@Test
	void testUpdateBilling_Success2() {
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(null);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		Optional<Billing> billing2 = Optional.of(billing);
		Billing billing3 = billing2.get();
        
			
			Mockito.when(billingRepository.findById(Mockito.anyInt()))
	          .thenReturn(billing2);
			Mockito.when(billingRepository.save(Mockito.anyObject()))
	          .thenReturn(billing);
			   
			
			Assertions.assertDoesNotThrow(() -> billingService.updateBillingById(1,billing));
		}
	
	
	
	
	@Test
	void testUpdateBilling_Failed() {
	
			Billing billing = new Billing();
			
			Assertions.assertDoesNotThrow(() -> billingService.updateBillingById(10,billing));
			
		}
		
	}
	
	
	@Nested 
	class DeleteBillingTest {
		
	@Test
	void testDeleteBilling_Success() {
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		Optional<Billing> billing2 = Optional.of(billing);
		
			
			Mockito.when(billingRepository.findById(1))
	          .thenReturn(billing2);
			Mockito.doNothing().when(billingRepository).deleteById(1);
			
			Assertions.assertDoesNotThrow(() -> billingService.deleteBillingById(1));
		}
	
	
	@Test
	void testDeleteBilling_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> billingService.deleteBillingById(1));
			
		}
		
	}
	
	@Nested 
	class TestGetBillingCostById {
		
	@Test
	void testGetBillingCostById_Success() {
		Billing billing = new Billing();
		billing.setBillingId(1);
		billing.setCost((float) 80);
		billing.setCustomerId(1);
		billing.setGst(5);
		billing.setOriginalCost((float) 100);
		billing.setServiceProviderId(1);
		billing.setTotalCost((float) 84);
		billing.setTransactions(null);
		Optional<Billing> billing2 = Optional.of(billing);
		
			
			Mockito.when(billingRepository.findById(Mockito.anyInt()))
	          .thenReturn(billing2);
			Mockito.when(billingRepository.save(Mockito.anyObject()))
	          .thenReturn(billing);
			//Mockito.doNothing().when(billing).setGst(Mockito.anyInt());
			   
			
			Assertions.assertDoesNotThrow(() -> billingService.getBillingCostById(1));
		}
	
	
	@Test
	void testGetBillingCostById_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> billingService.getBillingCostById(10));
			
		}
		
	}
	
}
