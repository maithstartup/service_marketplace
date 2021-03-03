package com.au.service_project.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.au.service_project.entity.Transaction;
import com.au.service_project.impl.TransactionServiceImpl;
import com.au.service_project.service.BillingService;
@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {
	@InjectMocks
	TransactionController transactionController;
	
	@Mock
	TransactionServiceImpl transactionService;

	@Mock
	BillingService billingService;

	
	@Nested
	class AddTransactionTest{
		  
		@Test
		void testAddTransaction_Success() {
			Transaction transaction =new Transaction();
			transaction.setTransactionId(1);
			transaction.setCustomerId(1);
			transaction.setBillingId(1);
			transaction.setTransactionAmount((float)80);
			transaction.setDate(null);
			transaction.setOriginalCost((float) 80);
			transaction.setServiceId(1);
			transaction.setStatus("pending");
			transaction.setTransactionRating((float) 4);
			Float cost = null;
			
			Mockito.when(transactionService.addTransaction(Mockito.anyObject()))
	          .thenReturn(transaction);
			
			Mockito.when(billingService.getBillingCostById(Mockito.anyInt()))
	          .thenReturn(cost);
			
			 ResponseEntity<Object>response= transactionController.addTransaction(transaction);
			 
			 Assertions.assertNotNull(response);
			 Assertions.assertDoesNotThrow(() -> transactionController.addTransaction(transaction));
			 
			 
		} 
		@Test
		void testAddTransaction_Failed() {
			Transaction transaction =new Transaction();
			Mockito.when(transactionService.addTransaction(Mockito.anyObject()))
	          .thenReturn(null);
			
			ResponseEntity<Object>response= transactionController.addTransaction(transaction);
			 
			 Assertions.assertNotNull(response);
		}
	
	}
	
	@Nested
	class GetTransactionTest{
		@Test
		void testGetTransaction_Success() {
			Transaction transaction =new Transaction();
			transaction.setTransactionId(1);
			transaction.setCustomerId(1);
			transaction.setBillingId(1);
			transaction.setTransactionAmount((float)80);
			transaction.setDate(null);
			transaction.setOriginalCost((float) 80);
			transaction.setServiceId(1);
			transaction.setStatus("pending");
			transaction.setTransactionRating((float) 4);
			  
			Mockito.when(transactionService.getTransactionById(Mockito.anyInt()))
	          .thenReturn(transaction);
			ResponseEntity<Object>response= transactionController.getTransaction(1);
			
			Assertions.assertNotNull(response);
			 Assertions.assertDoesNotThrow(() -> transactionController.getTransaction(1));
			
		}
		@Test
		void testGetTransaction_Failed() {
			Transaction transaction =new Transaction();
			Mockito.when(transactionService.getTransactionById(Mockito.anyInt()))
	          .thenReturn(null);
			ResponseEntity<Object>response= transactionController.getTransaction(1);
			
			Assertions.assertNotNull(response);
			
		}
	}
	@Nested
	class PutTransactionTest{
		@Test
		void testPutTransaction_Success() {
			Transaction transaction =new Transaction();
			transaction.setTransactionId(1);
			transaction.setCustomerId(1);
			transaction.setBillingId(1);
			transaction.setTransactionAmount((float)80);
			transaction.setDate(null);
			transaction.setOriginalCost((float) 80);
			transaction.setServiceId(1);
			transaction.setStatus("pending");
			transaction.setTransactionRating((float) 4);
			
			
			  
			Mockito.when(transactionService.updateTransactionById(Mockito.anyInt(), Mockito.anyObject()))
	          .thenReturn(transaction);
			ResponseEntity<Object>response= transactionController.putTransaction(1,transaction);
			
			Assertions.assertNotNull(response);
			 Assertions.assertDoesNotThrow(() -> transactionController.putTransaction(1,transaction));
			
		}
		@Test
		void testPutTransaction_Failed() {
			Transaction transaction =new Transaction();
			Mockito.when(transactionService.updateTransactionById(Mockito.anyInt(), Mockito.anyObject()))
	          .thenReturn(null);
			ResponseEntity<Object>response= transactionController.putTransaction(1,transaction);
			
			Assertions.assertNotNull(response);
			
		}
	}
	
	
	@Nested
	class DeleteTransactionTest{
		@Test
		void testDeleteTransaction_Success() {
			Transaction transaction =new Transaction();
			transaction.setTransactionId(1);
			transaction.setCustomerId(1);
			transaction.setBillingId(1);
			transaction.setTransactionAmount((float)80);
			transaction.setDate(null);
			transaction.setOriginalCost((float) 80);
			transaction.setServiceId(1);
			transaction.setStatus("pending");
			transaction.setTransactionRating((float) 4);
			
			
			  
			Mockito.when(transactionService.deleteTransactionById(Mockito.anyInt()))
	          .thenReturn("Deleted the Bill");
			ResponseEntity<Object>response= transactionController.deleteTransaction(1);
			
			Assertions.assertNotNull(response);
			 Assertions.assertDoesNotThrow(() -> transactionController.deleteTransaction(1));
			
		}
		@Test
		void testDeleteTransaction_Failed() {
			Transaction transaction =new Transaction();
			Mockito.when(transactionService.deleteTransactionById(Mockito.anyInt()))
	          .thenReturn(null);
			ResponseEntity<Object>response= transactionController.deleteTransaction(1);
			
			Assertions.assertNotNull(response);
			
		}
	}
	

}
