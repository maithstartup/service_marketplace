package com.au.service_project.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

import com.au.service_project.entity.Service;
import com.au.service_project.repository.ServiceRepository;

@ExtendWith(MockitoExtension.class)
class ServiceServiceImplTest {


	@InjectMocks
	ServiceServiceImpl serviceService;
	
	@Mock
	ServiceRepository serviceRepository;
	
	@Nested 
	class AddServiceTest {
		
	@Test
	void testAddService_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		
			Mockito.when(serviceRepository.save(Mockito.anyObject()))
	          .thenReturn("Success");
			
		
			
			Assertions.assertDoesNotThrow(() -> serviceService.addService(service));
		}
	
	
	
		
	}
	
	@Nested
	class SaveImageFileTest {
		
		@Test
		void testSaveImageFile_Success() {
			Service service=new Service();
			service.setServiceId(1);
			service.setServiceName("serv");
			service.setServiceProviderId(1);
			service.setCost((float)80);
			service.setDetails("good product");
			service.setDiscount((float) 80);
			service.setDiscountAvailability(true);
			service.setRating((float)3);
				Optional<Service> service2 = Optional.of(service);
			
			
			
			Mockito.when(serviceRepository.findById(Mockito.anyInt()))
	          .thenReturn(service2);
				
			Mockito.when(serviceRepository.save(Mockito.anyObject()))
	          .thenReturn(service);
			Assertions.assertDoesNotThrow(() -> serviceService.saveImageFile(1,null));
				
		}
	
		@Test
		void testGetService_Failed() {
				Assertions.assertDoesNotThrow(() -> serviceService.saveImageFile(1,null));
			}
		
	}
	
	
	
	@Nested 
	class GetServiceByIdTest {
		
	@Test
	void testGetService_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		
		Optional<Service> service2 = Optional.of(service);
		
			
			Mockito.when(serviceRepository.findById(Mockito.anyInt()))
	          .thenReturn(service2);
			
			Assertions.assertDoesNotThrow(() -> serviceService.getServiceById(1));
		}
	
	
	@Test
	void testGetService_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceService.getServiceById(10));
			
		}
		
	}
	
	@Nested 
	class GetServiceByNameTest {
		
	@Test
	void testGetService_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		
		Optional<Service> service2 = Optional.of(service);
		
			
			Mockito.when(serviceRepository.findServiceByServiceName(Mockito.anyString()))
	          .thenReturn(service2);
			
			Assertions.assertDoesNotThrow(() -> serviceService.getServiceByName("abc@gmail.com"));
		}
	
	
	@Test
	void testGetService_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceService.getServiceByName("abc@gmail.com"));
			
		}
		
	}
	
	
	
	
	
	
	@Nested 
	class TestUpdateServiceById {
		
	@Test
	void testUpdateService_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		service.setWarranty((float)2);
		Optional<Service> service2 = Optional.of(service);
		Service service3 = service2.get();
        
			
			Mockito.when(serviceRepository.findById(Mockito.anyInt()))
	          .thenReturn(service2);
			Mockito.when(serviceRepository.save(Mockito.anyObject()))
	          .thenReturn(service);
			   
			
			Assertions.assertDoesNotThrow(() -> serviceService.updateServiceById(1,service));
		}
	
	@Test
	void testUpdateService_Success2() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost(null);
		service.setDetails(null);
		service.setDiscount(null);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		service.setWarranty(null);
		Optional<Service> service2 = Optional.of(service);
		Service service3 = service2.get();
        
			
			Mockito.when(serviceRepository.findById(Mockito.anyInt()))
	          .thenReturn(service2);
			Mockito.when(serviceRepository.save(Mockito.anyObject()))
	          .thenReturn(service);
			   
			
			Assertions.assertDoesNotThrow(() -> serviceService.updateServiceById(1,service));
		}	
	
	
	@Test
	void testUpdateService_Failed() {
	
			Service service = new Service();
			
			Assertions.assertDoesNotThrow(() -> serviceService.updateServiceById(10,service));
			
		}
		
	}
	
	
	
	@Nested 
	class TestUpdateServiceByName {
		
	@Test
	void testUpdateService_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		service.setWarranty((float) 2);
		
		
		Optional<Service> service2 = Optional.of(service);
		Service service3 = service2.get();
        
			
			Mockito.when(serviceRepository.findServiceByServiceName(Mockito.anyString()))
	          .thenReturn(service2);
			Mockito.when(serviceRepository.save(Mockito.anyObject()))
	          .thenReturn(service);
			   
			
			Assertions.assertDoesNotThrow(() -> serviceService.updateServiceByName("serv",service));
		}
	
	@Test
	void testUpdateService_Success2() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost(null);
		service.setDetails(null);
		service.setDiscount(null);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		service.setWarranty(null);
		
		Optional<Service> service2 = Optional.of(service);
		Service service3 = service2.get();
        
			
			Mockito.when(serviceRepository.findServiceByServiceName(Mockito.anyString()))
	          .thenReturn(service2);
			Mockito.when(serviceRepository.save(Mockito.anyObject()))
	          .thenReturn(service);
			   
			
			Assertions.assertDoesNotThrow(() -> serviceService.updateServiceByName("serv",service));
		}
	
	
	
	@Test
	void testUpdateService_Failed() {
	
			Service service = new Service();
			
			Assertions.assertDoesNotThrow(() -> serviceService.updateServiceByName("serv",service));
			
		}
		
	}
	
	
	
	
	
	
	
	@Nested 
	class DeleteServiceTest {
		
	@Test
	void testDeleteService_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		
		Optional<Service> service2 = Optional.of(service);
		
			
			Mockito.when(serviceRepository.findById(1))
	          .thenReturn(service2);
			Mockito.doNothing().when(serviceRepository).deleteById(1);
			
			Assertions.assertDoesNotThrow(() -> serviceService.deleteServiceById(1));
		}
	
	
	@Test
	void testDeleteService_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceService.deleteServiceById(1));
			
		}
		
	}
	
	
	
	@Nested 
	class DeleteServiceTestByName {
		
	@Test
	void testDeleteService_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		
		Optional<Service> service2 = Optional.of(service);
		
			
			Mockito.when(serviceRepository.findServiceByServiceName("serv"))
	          .thenReturn(service2);
			Mockito.doNothing().when(serviceRepository).delete(service);
			
			Assertions.assertDoesNotThrow(() -> serviceService.deleteServiceByName("serv"));
		}
	
	
	@Test
	void testDeleteService_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceService.deleteServiceByName("serv"));
			
		}
		
	}
	
	
	@Nested 
	class GetSRatingsByIdTest {
		
	@Test
	void testGetSRatingsById_Success() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		
		Optional<Service> service2 = Optional.of(service);
		
			
			Mockito.when(serviceRepository.findById(1))
	          .thenReturn(service2);
			Mockito.when(serviceRepository.save(Mockito.anyObject()))
	          .thenReturn(service);
			
			Assertions.assertDoesNotThrow(() -> serviceService.getSRatingsById(1));
		}
	
	
	@Test
	void testGetSRatingsById_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceService.getSRatingsById(1));
			
		}
		
	}
	
	
	
	
	
	
	@Nested
	class GetServicesByCategoryAndCityTest {
		
	@Test
	void getServicesByCategoryAndCity() {
		Service service=new Service();
		service.setServiceId(1);
		service.setServiceName("serv");
		service.setServiceProviderId(1);
		service.setCost((float)80);
		service.setDetails("good product");
		service.setDiscount((float) 80);
		service.setDiscountAvailability(true);
		service.setRating((float)3);
		
		List<Service> services = null;
		Mockito.when(serviceRepository.findServicesByCategoryAndCity(1,"hyd")).thenReturn(services);
		Assertions.assertDoesNotThrow(() -> serviceService.getServicesByCategoryAndCity(1,"hyd"));
		
	}
		
		
	}
	
	
	

}
