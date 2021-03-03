package com.au.service_project.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.au.service_project.service.ServiceProviderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.au.service_project.entity.Service;

import com.au.service_project.impl.ServiceServiceImpl;
@ExtendWith(MockitoExtension.class)
class ServiceControllerTest {
	 @InjectMocks
	    ServiceController serviceController;
	    @Mock
	    ServiceServiceImpl serviceService;

	    @Mock
	ServiceProviderService serviceProviderService;
	    
	    @Nested
	    class AddServiceTest{
	  
	    	@Test 
	    	void testAddService_Success() { 
	    		Service service=new Service();
	    		service.setServiceId(1);
	    		service.setServiceName("bbas");
	    		service.setServiceProviderId(1);
	    		service.setCost((float)80);
	    		service.setDetails("good product");
	    		service.setDiscount((float) 80);
	    		service.setDiscountAvailability(true);
	    		service.setRating((float)3);

	    		Mockito.when(serviceService.addService(service))
		          .thenReturn("Success");
	    		Mockito.when(serviceProviderService.addServiceProviderCategory(Mockito.any()))
						.thenReturn(null);
				ResponseEntity<Object> response = serviceController.addService(service);
				
				Assertions.assertNotNull(response);
				//Assertions.assertDoesNotThrow(() -> serviceController.addService(service));
			
		}
	    	 
	    	@Test
	    	void testAddService_Failed() {
	    		Service service=new Service();
	    		Mockito.when(serviceService.addService(service))
		          .thenReturn(null);
				ResponseEntity<Object> response = serviceController.addService(service);
				
				Assertions.assertNotNull(response);
	    	}
	   }
	    
	    
	   @Nested
	    class HandleImagePostTest{
	    	@Test
	    	void testHandleImagePost_Success() {
	    		Service service=new Service();
	    		service.setServiceId(1);
	    		service.setServiceName("bbas");
	    		service.setServiceProviderId(1);
	    		service.setCost((float)80);
	    		service.setDetails("good product");
	    		service.setDiscount((float) 80);
	    		service.setDiscountAvailability(true);
	    		service.setRating((float)3);
	    		
	    		Mockito.when(serviceService.saveImageFile(Mockito.anyInt(), Mockito.any()))
		          .thenReturn("Image Added");
	    		ResponseEntity response = serviceController.handleImagePost(1, null);
				
				Assertions.assertNotNull(response);
				Assertions.assertDoesNotThrow(() -> serviceController.handleImagePost(1,null));
	    		
	    	}
	    	@Test
	    	void testHandleImagePost_Failed() {
	    		
	    		Service service=new Service();
	    		Mockito.when(serviceService.saveImageFile(Mockito.anyInt(),Mockito.any()))
		          .thenReturn(null);
	    		ResponseEntity response = serviceController.handleImagePost(1, null);
				
				Assertions.assertNotNull(response);
	    	}
	    }
	   

	    
	    @Nested
	    class GetServiceByIdTest{
	    	
	    	@Test
	    	void testGetServiceById_Success() {
	    		
	    		Service service=new Service();
	    		service.setServiceId(1);
	    		service.setServiceName("bbas");
	    		service.setServiceProviderId(1);
	    		service.setCost((float)80);
	    		service.setDetails("good product");
	    		service.setDiscount((float) 80);
	    		service.setDiscountAvailability(true);
	    		service.setRating((float)3);
	    		Mockito.when(serviceService.getServiceById(Mockito.anyInt()))
		          .thenReturn(service);
	    		
	    		ResponseEntity<Object> response = serviceController.getServiceById(1);
				
				Assertions.assertNotNull(response);
				Assertions.assertDoesNotThrow(() -> serviceController.getServiceById(1));
		
	    		
	    		
	    	}
	    	@Test
	    	void testGetServiceById_Failed() {
	    		Service service=new Service();
	    		Mockito.when(serviceService.getServiceById(Mockito.anyInt()))
		          .thenReturn(null);
	    		
	    		ResponseEntity<Object> response = serviceController.getServiceById(1);
				
				Assertions.assertNotNull(response);
	    	}
	    }
	    
	    @Nested
	    class GetServiceByNameTest{
	    	
	    	@Test
	    	void testGetServiceByName_Success() {
	    		Service service=new Service();
	    		service.setServiceId(1);
	    		service.setServiceName("bbas");
	    		service.setServiceProviderId(1);
	    		service.setCost((float)80);
	    		service.setDetails("good product");
	    		service.setDiscount((float) 80);
	    		service.setDiscountAvailability(true);
	    		service.setRating((float)3);
	    		Mockito.when(serviceService.getServiceByName(Mockito.anyString()))
		          .thenReturn(service);
	    		
	    		ResponseEntity<Object> response = serviceController.getServiceByName("bbas");
				
				Assertions.assertNotNull(response);
				Assertions.assertDoesNotThrow(() -> serviceController.getServiceByName("bbas"));
		
	    		
	    		
	    	}
	    	@Test
	    	void testGetServiceByName_Failed() {
	    		Service service=new Service();
	    		Mockito.when(serviceService.getServiceByName(Mockito.anyString()))
		          .thenReturn(null);
	    		
	    		ResponseEntity<Object> response = serviceController.getServiceByName("bbas");
				
				Assertions.assertNotNull(response);
				
		
	    	}
	    } 
	    
	    
	    
	    
	    @Nested
		class UpdateServiceByIdTest{
			@Test
			void testUpdateServiceById_Success() {
				Service service=new Service();
	    		service.setServiceId(1);
	    		service.setServiceName("bbas");
	    		service.setServiceProviderId(1);
	    		service.setCost((float)80);
	    		service.setDetails("good product");
	    		service.setDiscount((float) 80);
	    		service.setDiscountAvailability(true);
	    		service.setRating((float)3);
				Mockito.when(serviceService.updateServiceById(Mockito.anyInt(), Mockito.anyObject()))
		          .thenReturn(service);
				Service response = serviceService.updateServiceById(1, service);
				
				Assertions.assertNotNull(response);
				Assertions.assertDoesNotThrow(() -> serviceController.updateServiceById(1, service));
		
				
			}
			
			@Test
			void testUpdateServiceById_Failed() {
				Service service=new Service();
				Mockito.when(serviceService.updateServiceById(Mockito.anyInt(), Mockito.any()))
		          .thenReturn(null);
				ResponseEntity<Object> response = serviceController.updateServiceById(1, service);
				
				Assertions.assertEquals("not able to update Service",response.getBody());
			} 
		} 
	    
	    @Nested
	 		class UpdateServiceByNameTest{
	 			@Test
	 			void testUpdateServiceByName_Success() {
	 				Service service=new Service();
	 	    		service.setServiceId(1);
	 	    		service.setServiceName("bbas");
	 	    		service.setServiceProviderId(1);
	 	    		service.setCost((float)80);
	 	    		service.setDetails("good product");
	 	    		service.setDiscount((float) 80);
	 	    		service.setDiscountAvailability(true);
	 	    		service.setRating((float)3);
	 				Mockito.when(serviceService.updateServiceByName(Mockito.anyString(), Mockito.anyObject()))
	 		          .thenReturn(service);
	 				ResponseEntity<Object> response = serviceController.updateServiceByName("bbas", service);
	 				
	 				Assertions.assertNotNull(response);
	 				Assertions.assertDoesNotThrow(() -> serviceController.updateServiceByName("bbas", service));
	 		
	 				
	 			}
	 			
	 			@Test
	 			void testUpdateServiceByName_Failed() {
	 				Service service=new Service();
	 				Mockito.when(serviceService.updateServiceByName(Mockito.anyString(), Mockito.anyObject()))
	 		          .thenReturn(null);
	 				ResponseEntity response = serviceController.updateServiceByName("bbas", service);
	 				
	 				Assertions.assertNotNull(response);
	 			} 
	 		} 


	    
	    
	    
	    
	    
	    	@Nested
	    	class DeleteServiceByIdTest{
	    		@Test
	    		void testDeleteServiceById_Success() {
	    			Service service=new Service();
	 	    		service.setServiceId(1);
	 	    		service.setServiceName("bbas");
	 	    		service.setServiceProviderId(1);
	 	    		service.setCost((float)80);
	 	    		service.setDetails("good product");
	 	    		service.setDiscount((float) 80);
	 	    		service.setDiscountAvailability(true);
	 	    		service.setRating((float)3);
	    			Mockito.when(serviceService.deleteServiceById(Mockito.anyInt()))
	  	          .thenReturn("Deleted the Service ");
	    			ResponseEntity<Object> response = serviceController.deleteServiceById(1);
	    			
	    			Assertions.assertNotNull(response);
	    			Assertions.assertDoesNotThrow(() -> serviceController.deleteServiceById(1));
	    	
	    			
	    		}
	    		
	    		@Test
	    		void testDeleteServiceById_Failed() {
	    			Service service=new Service();
	    			Mockito.when(serviceService.deleteServiceById(Mockito.anyInt()))
		  	          .thenReturn(null);
		    			ResponseEntity<Object> response = serviceController.deleteServiceById(1);
		    			
		    			Assertions.assertNotNull(response);
	    		}
	    	}
	    
	    	@Nested
	    	class DeleteServiceByNameTest{
	    		@Test
	    		void testDeleteServiceByName_Success() {
	    			Service service=new Service();
	 	    		service.setServiceId(1);
	 	    		service.setServiceName("bbas");
	 	    		service.setServiceProviderId(1);
	 	    		service.setCost((float)80);
	 	    		service.setDetails("good product");
	 	    		service.setDiscount((float) 80);
	 	    		service.setDiscountAvailability(true);
	 	    		service.setRating((float)3);
	    			Mockito.when(serviceService.deleteServiceByName(Mockito.anyString()))
	  	          .thenReturn("Deleted the Service ");
	    			ResponseEntity<Object> response = serviceController.deleteServiceByName("bbas");
	    			
	    			Assertions.assertNotNull(response);
	    			Assertions.assertDoesNotThrow(() -> serviceController.deleteServiceByName("bbas"));
	    	
	    			
	    		}
	    		
	    		@Test
	    		void testDeleteServiceByName_Failed() {
	    			Service service=new Service();
	    			Mockito.when(serviceService.deleteServiceByName(Mockito.anyString()))
		  	          .thenReturn(null);
		    			ResponseEntity<Object> response = serviceController.deleteServiceByName("bbas");
		    			
		    			Assertions.assertNotNull(response);
	    		}
	    	}
	    
	    
	    
	   
	    
	    @Nested
	    class GetSRatingsByIdTest{
	    	
	    	@Test
	    	void testGetSRatingsById_Success() {
	    		 
		    			Service service=new Service();
		 	    		service.setServiceId(1);
		 	    		service.setServiceName("bbas");
		 	    		service.setServiceProviderId(1);
		 	    		service.setCost((float)80);
		 	    		service.setDetails("good product");
		 	    		service.setDiscount((float) 80);
		 	    		service.setDiscountAvailability(true);
		 	    		service.setRating((float)3);
		 	    		service.setServiceRatings(null);
	    		
	    		
	    		
	    		Mockito.when(serviceService.getSRatingsById(Mockito.anyInt()))
		          .thenReturn(service.getServiceRatings());
	    		ResponseEntity sRatings = serviceController.getSRatingsById(1);
	    		Assertions.assertNotNull(sRatings);
				Assertions.assertDoesNotThrow(() -> serviceController.getSRatingsById(1));
		
	    		  
	    		 
	    		
	    		
	    		
	    	}
	    	@Test
	    	void testGetSRatingsById_Failed() {
	    		Service service=new Service();

	    		Mockito.when(serviceService.getSRatingsById(Mockito.anyInt()))
		          .thenReturn(null);
	    		ResponseEntity sRatings = serviceController.getSRatingsById(1);
	    		Assertions.assertNotNull(sRatings);

	    	}

	    	@Nested
			class GetServicesByCategoryAndCityTest{

	    		@Test
				void testGetServicesByCategoryAndCity_Success(){

	    			List<Service> serviceList = new ArrayList<>();

	    			Mockito.when(serviceService.getServicesByCategoryAndCity(Mockito.anyInt(),Mockito.anyString()))
							.thenReturn(serviceList);

	    			ResponseEntity response = serviceController.getServicesByCategoryAndCity(1,"Chennai");

	    			Assertions.assertNotNull(response);



				}
				@Test
				void testGetServicesByCategoryAndCity_Failed(){

					//List<Service> serviceList = new ArrayList<>();

					Mockito.when(serviceService.getServicesByCategoryAndCity(Mockito.anyInt(),Mockito.anyString()))
							.thenReturn(null);

					ResponseEntity response = serviceController.getServicesByCategoryAndCity(1,"Chennai");

					Assertions.assertNotNull(response);



				}



			}
	    }
	    
	    
	    
}
