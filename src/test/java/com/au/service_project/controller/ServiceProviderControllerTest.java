package com.au.service_project.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.impl.ServiceProviderImpl;
@ExtendWith(MockitoExtension.class)
class ServiceProviderControllerTest {
    @InjectMocks
    ServiceProviderController serviceProviderController;
    @Mock
    ServiceProviderImpl serviceProviderService;
    
    @InjectMocks
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    @Nested
    class AddServiceProviderTest{
  
    	@Test  
    	void testAddServiceProvider_Success() { 
    		ServiceProvider serviceProvider=new ServiceProvider();
    		serviceProvider.setServiceProviderId(1);
    		serviceProvider.setCompanyName("abc company");
    		serviceProvider.setEmailId("abc@gmail.com");
    		serviceProvider.setOwnerName("basheer");
    		serviceProvider.setPhoneNum("1234567895");
    		serviceProvider.setPassword("ggfhg");
    		
    		
    		
    		Mockito.when(serviceProviderService.addServiceProvider(Mockito.anyObject()))
	          .thenReturn("Created Service Provider Succesfully");
			ResponseEntity<Object> response = serviceProviderController.addServiceProvider(serviceProvider);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> serviceProviderController.addServiceProvider(serviceProvider));
	
		
	}
    	
    	@Test
    	void testAddServiceProvider_Failed() {
    		ServiceProvider serviceProvider=new ServiceProvider();
    		Mockito.when(serviceProviderService.addServiceProvider(Mockito.anyObject()))
	          .thenReturn(null);
			ResponseEntity<Object> response = serviceProviderController.addServiceProvider(serviceProvider);
			
			Assertions.assertNotNull(response);
    	}
   }
  
 /* @Nested
    class HandleImagePostTest{
    	@Test
    	void testHandleImagePost_Success() {
    		ServiceProvider serviceProvider=new ServiceProvider();
    		serviceProvider.setServiceProviderId(1);
    		serviceProviderService.saveImageFile(1,null);
    		Mockito.when(serviceProviderService.saveImageFile(Mockito.anyInt(), Mockito.anyByte()))
	          .thenReturn("Image Added");
    		String response = serviceProviderService.saveImageFile(1,null);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> serviceProviderService.saveImageFile(1,null));
    		
    	}
    	@Test
    	void testHandleImagePost_Failed() {
    		
    		
    		
    	}
    }*/
   
   
    @Nested
    class GetServiceProviderAllTest{
    	@Test
    	void testGetServiceProviderAll_Success() {
    		List<ServiceProvider> sp = serviceProviderService.getServiceProviderAll();
    		Mockito.when(serviceProviderService.getServiceProviderAll())
	          .thenReturn(sp);
    		Assertions.assertNotNull(sp);
			Assertions.assertDoesNotThrow(() -> serviceProviderController.getServiceProviderAll());
  		
    	}
    	@Test
    	void testGetServiceProviderAll_Failed() {

			//List<ServiceProvider> sp = new ArrayList<>();
			Mockito.when(serviceProviderService.getServiceProviderAll())
					.thenReturn(null);

			Assertions.assertEquals("not able list service providers",serviceProviderController.getServiceProviderAll().getBody());
			//Assertions.assertDoesNotThrow(() -> serviceProviderController.getServiceProviderAll());

		}
    	
    }
    
    @Nested
    class GetServiceProviderTest{
    	
    	@Test
    	void testGetServiceProvider_Success() {
    		
    		ServiceProvider serviceProvider=new ServiceProvider();
    		serviceProvider.setServiceProviderId(1);
    		serviceProvider.setCompanyName("abc company");
    		serviceProvider.setEmailId("abc@gmail.com");
    		serviceProvider.setOwnerName("basheer");
    		serviceProvider.setPhoneNum("1234567895");
    		serviceProvider.setPassword("ggfhg");
    		Mockito.when(serviceProviderService.getServiceProviderById(Mockito.anyInt()))
	          .thenReturn(serviceProvider);
    		
    		ResponseEntity<Object> response = serviceProviderController.getServiceProvider(1);
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> serviceProviderController.getServiceProvider(1));
	
    		
    		
    	}
    	@Test
    	void testGetServiceProvider_Failed() {
//    		Mockito.when(serviceProviderService.getServiceProviderById(Mockito.anyInt()))
//	          .thenReturn(null);
  		
  		ResponseEntity<Object> response = serviceProviderController.getServiceProvider(10);
  		Assertions.assertDoesNotThrow(() -> serviceProviderController.getServiceProvider(10));
//			Assertions.assertNotNull(response);


//			Mockito.when(serviceProviderService.getServiceProviderByEmail(Mockito.anyString()))
//					.thenReturn(null);
//
//			ResponseEntity<Object> response = serviceProviderController.getServiceProviderByEmail("abc@gmail.com");
//
//			Assertions.assertNotNull(response);
    	}
    }
    
    @Nested
    class GetServiceProviderByEmailTest{
    	
    	@Test
    	void testGetServiceProviderByEmail_Success() {
    		
    		ServiceProvider serviceProvider=new ServiceProvider();
    		serviceProvider.setServiceProviderId(1);
    		serviceProvider.setCompanyName("abc company");
    		serviceProvider.setEmailId("abc@gmail.com");
    		serviceProvider.setOwnerName("basheer");
    		serviceProvider.setPhoneNum("1234567895");
    		serviceProvider.setPassword("ggfhg");
    		serviceProvider.getSpRating();
    		Mockito.when(serviceProviderService.getServiceProviderByEmail(Mockito.anyString()))
	          .thenReturn(serviceProvider);
    		
    		ResponseEntity<Object> response = serviceProviderController.getServiceProviderByEmail("abc@gmail.com");
			
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> serviceProviderController.getServiceProviderByEmail("abc@gmail.com"));
	
    		
    		
    	}
    	@Test
    	void testGetServiceProviderByEmail_Failed() {
    		Mockito.when(serviceProviderService.getServiceProviderByEmail(Mockito.anyString()))
	          .thenReturn(null);
  		
  		ResponseEntity<Object> response = serviceProviderController.getServiceProviderByEmail("abc@gmail.com");
			
			Assertions.assertNotNull(response);
    	}
    } 
    
    
    
    
    @Nested
	class PutServiceProviderTest{
		@Test
		void testPutServiceProvider_Success() {
			ServiceProvider serviceProvider=new ServiceProvider();
			serviceProvider.setServiceProviderId(1);
    		serviceProvider.setCompanyName("abc company");
    		serviceProvider.setEmailId("abc@gmail.com");
    		serviceProvider.setOwnerName("basheer");
    		serviceProvider.setPhoneNum("1234567895");
    		serviceProvider.setPassword("ggfhg");
			Mockito.when(serviceProviderService.updateServiceProviderById(Mockito.anyInt(), Mockito.anyObject()))
	          .thenReturn(serviceProvider);
//			ServiceProvider response = serviceProviderService.updateServiceProviderById(1, serviceProvider);
			
//			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> serviceProviderController.putServiceProvider(1, serviceProvider));
	
			
		}
		
		@Test
		void testPutServiceProvider_Failed() {
			ServiceProvider serviceProvider=new ServiceProvider();
			Mockito.when(serviceProviderService.updateServiceProviderById(Mockito.anyInt(), Mockito.anyObject()))
	          .thenReturn(null);
			ResponseEntity<Object> response = serviceProviderController.putServiceProvider(1,serviceProvider);
			System.out.println(response.getBody());
			Assertions.assertNotNull(response);
		} 
	} 

    
    
    
    
    
    	@Nested
    	class DeleteServiceProviderByIdTest{
    		@Test
    		void testDeleteServiceProviderById_Success() {
    			ServiceProvider serviceProvider=new ServiceProvider();
    			serviceProvider.setServiceProviderId(1);
        		serviceProvider.setCompanyName("abc company");
        		serviceProvider.setEmailId("abc@gmail.com");
        		serviceProvider.setOwnerName("basheer");
        		serviceProvider.setPhoneNum("1234567895");
        		serviceProvider.setPassword("ggfhg");
    			Mockito.when(serviceProviderService.deleteServiceProviderById(Mockito.anyInt()))
  	          .thenReturn("Deleted the Service Provider");
    			ResponseEntity<Object> response = serviceProviderController.deleteServiceProviderById(1);
    			
    			Assertions.assertNotNull(response);
    			Assertions.assertDoesNotThrow(() -> serviceProviderController.deleteServiceProviderById(1));
    	
    			
    		}
    		
    		@Test
    		void testDeleteServiceProviderById_Failed() {
    			ServiceProvider serviceProvider=new ServiceProvider();
    			Mockito.when(serviceProviderService.deleteServiceProviderById(Mockito.anyInt()))
    	          .thenReturn(null);
      			ResponseEntity<Object> response = serviceProviderController.deleteServiceProviderById(1);
      			
      			Assertions.assertNotNull(response);
    		}
    	}
    
    
    
    
     @Nested
     class AddServiceProviderCategoryTest{
    	 @Test
    	 void testAddServiceProviderCategory_Success() {
    		 ServiceProvider serviceProvider=new ServiceProvider();
    		 serviceProvider.setServiceProviderId(1);
    		 Mockito.when(serviceProviderService.addServiceProviderCategory(Mockito.anyMap()))
	          .thenReturn("Category Added");
    		 Map<String,Integer> temp= new HashMap<>();
    		 temp.put("keyy",1);
    		 ResponseEntity<Object> response = serviceProviderController.addServiceProviderCategory(temp);

 			Assertions.assertNotNull(response);
 			Assertions.assertDoesNotThrow(() -> serviceProviderController.addServiceProviderCategory(null));
 	
     		
    	 }
    	 @Test
    	 void testAddServiceProviderCategory_Failed() {
    		 ServiceProvider serviceProvider=new ServiceProvider();
    		 Mockito.when(serviceProviderService.addServiceProviderCategory(Mockito.anyMap()))
	          .thenReturn(null);
    		 Map<String,Integer> temp = new HashMap<>();
    		 ResponseEntity<Object> response = serviceProviderController.addServiceProviderCategory(temp);

			Assertions.assertNotNull(response);
    	 }
    	 
     }

//     @Nested
//	 class CustomerLoginTest{
//
//    	@Test
//		 void testCustomerLogin_Succes(){
//			ServiceProvider serviceProvider=new ServiceProvider();
//			serviceProvider.setEmailId("mai@gmail.com");
//			serviceProvider.setPassword("123");
//
//			Mockito.when(serviceProviderService.getServiceProviderByEmail(Mockito.any()))
//					.thenReturn(serviceProvider);
//
//			Map<String,String> loginInstance = null;
//			loginInstance.put("password","123");
//			ResponseEntity<Object> response = serviceProviderController.customerLogin(loginInstance);
//			Assertions.assertEquals(serviceProvider.getClass(),response.getClass());
//
//
//		}
//
//	 }


   
    
    @Nested
    class GetSRatingsByIdTest{
    	
    	@Test
    	void testGetSRatingsById_Success() {
    		
    		ServiceProvider serviceProvider=new ServiceProvider();
    		serviceProvider.setServiceProviderId(1);
    		serviceProvider.setCompanyName("abc company");
    		serviceProvider.setEmailId("abc@gmail.com");
    		serviceProvider.setOwnerName("basheer");
    		serviceProvider.setPhoneNum("1234567895");
    		serviceProvider.setPassword("ggfhg");
    		
    		//Double spRatings = serviceProviderService.getSPRatingsById(1);
    		Mockito.when(serviceProviderService.getSPRatingsById(Mockito.anyInt()))
	          .thenReturn(4.5);



    		Assertions.assertEquals(4.5,serviceProviderController.getSRatingsById(1).getBody());
			//Assertions.assertDoesNotThrow(() -> serviceProviderService.getSPRatingsById(1));
	

    		
    		
    	}
    	@Test
    	void testGetSRatingsById_Failed() {
    		ServiceProvider serviceProvider=new ServiceProvider();
    		Mockito.when(serviceProviderService.getSPRatingsById(Mockito.anyInt()))
	          .thenReturn(null);
    		
    		//Double spRatings = serviceProviderService.getSPRatingsById(1);
			Assertions.assertEquals("not able to rate service provider",serviceProviderController.getSRatingsById(4).getBody());

    	}
    }
    
    
    
    

}
