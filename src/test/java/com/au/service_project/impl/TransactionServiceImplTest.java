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
import com.au.service_project.entity.Transaction;
import com.au.service_project.repository.TransactionRepository;
import com.au.service_project.service.ServiceService;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

	@InjectMocks
	TransactionServiceImpl transactionService;
	
	@Mock
	TransactionRepository transactionRepository;

	@Mock
	ServiceService serviceService;

	
	@Nested 
	class AddTransactionTest {
		
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
		Service service = new Service();
		service.setDiscountAvailability(true);
		service.setDiscount((float)5);
		service.getDiscount();
		
		
			
			Mockito.when(transactionRepository.save(Mockito.anyObject()))
	          .thenReturn(transaction);
			
			Mockito.when(serviceService.getServiceById(Mockito.anyInt()))
	          .thenReturn(service);
		
			
			
			Assertions.assertDoesNotThrow(() -> transactionService.addTransaction(transaction));
		}
	@Test
	void testAddTransaction_Success2() {
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
		Service service = new Service();
		service.setDiscountAvailability(false);
		
			
			Mockito.when(transactionRepository.save(Mockito.anyObject()))
	          .thenReturn(transaction);
			
			Mockito.when(serviceService.getServiceById(Mockito.anyInt()))
	          .thenReturn(service);
			
			
            		
			
			Assertions.assertDoesNotThrow(() -> transactionService.addTransaction(transaction));
		}	
	
	@Test
	void testAddTransaction_Failed() throws Exception{
	
			Transaction transaction = new Transaction();
			
			Assertions.assertThrows(Exception.class,() -> transactionService.addTransaction(transaction));
			
		}
		
	}
	
	
	@Nested 
	class GetTransactionByIdTest {
		
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
		Optional<Transaction> transaction2 = Optional.of(transaction);
		
			
			Mockito.when(transactionRepository.findById(Mockito.anyInt()))
	          .thenReturn(transaction2);
			
			Assertions.assertDoesNotThrow(() -> transactionService.getTransactionById(1));
		}
	
	
	@Test
	void testGetTransaction_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> transactionService.getTransactionById(10));
			
		}
		
	}
	
	
	@Nested 
	class TestUpdateTransactionById {
		
	@Test
	void testUpdateTransaction_Success() {
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
		
		Optional<Transaction> transaction2 = Optional.of(transaction);
		Transaction transaction3 = transaction2.get();
       
			
			Mockito.when(transactionRepository.findById(Mockito.anyInt()))
	          .thenReturn(transaction2);
			Mockito.when(transactionRepository.save(Mockito.anyObject()))
	          .thenReturn(transaction);
			   
			
			Assertions.assertDoesNotThrow(() -> transactionService.updateTransactionById(1,transaction));
		}
	
	
	
	@Test
	void testUpdateTransaction_Failed() {
	
			Transaction transaction = new Transaction();
			
			Assertions.assertDoesNotThrow(() -> transactionService.updateTransactionById(10,transaction));
			
		}
		
	}
	
	
	@Nested 
	class DeleteTransactionTest {
		
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
		
		Optional<Transaction> transaction2 = Optional.of(transaction);
		
			
			Mockito.when(transactionRepository.findById(1))
	          .thenReturn(transaction2);
			Mockito.doNothing().when(transactionRepository).deleteById(1);
			
			Assertions.assertDoesNotThrow(() -> transactionService.deleteTransactionById(1));
		}
	
	
	@Test
	void testDeleteTransaction_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> transactionService.deleteTransactionById(1));
			
		}
		
	}
	

}
