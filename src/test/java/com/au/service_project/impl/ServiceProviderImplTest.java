package com.au.service_project.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import com.au.service_project.entity.Billing;
import com.au.service_project.entity.Category;
import com.au.service_project.entity.Service;
import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.repository.BillingRepository;
import com.au.service_project.repository.ServiceProviderRepository;
import com.au.service_project.service.CategoryService;

@ExtendWith(MockitoExtension.class)
class ServiceProviderImplTest {

	@InjectMocks
	ServiceProviderImpl serviceProviderService;
	
	@Mock
	ServiceProviderRepository serviceProviderRepository;

	@Mock
	CategoryService categoryService;

	
	@Mock
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Nested 
	class AddServiceProviderTest {
		
	@Test
	void testAddServiceProvider_Success() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		
			Mockito.when(serviceProviderRepository.save(Mockito.anyObject()))
	          .thenReturn(serviceProvider);
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.addServiceProvider(serviceProvider));
		}
	
	
	@Test
	void testAddServiceProvider_Failed() throws Exception{
	
			//ServiceProvider serviceProvider = new ServiceProvider();
			
			Assertions.assertThrows(Exception.class,() -> serviceProviderService.addServiceProvider(null));
			
		}
		
	}
	
	@Nested
	class SaveImageFileTest {
		
		@Test
		void testSaveImageFile_Success() {
			ServiceProvider serviceProvider=new ServiceProvider();
			serviceProvider.setServiceProviderId(1);
			serviceProvider.setServiceProviderPic(null);
			Optional<ServiceProvider> serviceProvider2 = Optional.of(serviceProvider);
			MultipartFile file = null;
			Byte[] byteObjects = new Byte[5];
			int i=0;
			
			Mockito.when(serviceProviderRepository.findById(Mockito.anyInt()))
	          .thenReturn(serviceProvider2);
				
			Mockito.when(serviceProviderRepository.save(Mockito.anyObject()))
	          .thenReturn(serviceProvider);
			Assertions.assertDoesNotThrow(() -> serviceProviderService.saveImageFile(1,null));
				
		}
	
		@Test
		void testGetServiceProvider_Failed() {
				Assertions.assertDoesNotThrow(() -> serviceProviderService.saveImageFile(1,null));
			}
		
	}
	
	
	
	@Nested 
	class GetServiceProviderByIdTest {
		
	@Test
	void testGetServiceProvider_Success() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		Optional<ServiceProvider> serviceProvider2 = Optional.of(serviceProvider);
		
			
			Mockito.when(serviceProviderRepository.findById(Mockito.anyInt()))
	          .thenReturn(serviceProvider2);
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.getServiceProviderById(1));
		}
	
	
	@Test
	void testGetServiceProvider_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.getServiceProviderById(10));
			
		}
		
	}
	
	@Nested 
	class GetServiceProviderByEmailIdTest {
		
	@Test
	void testGetServiceProvider_Success() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		serviceProvider.setSpRating(2.0);
		Optional<ServiceProvider> serviceProvider2 = Optional.of(serviceProvider);
		
			
			Mockito.when(serviceProviderRepository.findServiceProviderByEmailId(Mockito.anyString()))
	          .thenReturn(serviceProvider2);
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.getServiceProviderByEmail("abc@gmail.com"));
		}
	
	
	@Test
	void testGetServiceProvider_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.getServiceProviderByEmail("abc@gmail.com"));
			
		}
		
	}
	
	
	@Nested 
	class TestGetServiceProviderAll {
		
	@Test
	void testGetServiceProviderAll() {
		List<ServiceProvider> serviceProvider2 = null;
//		Mockito.when(serviceProviderRepository.findAll()
//        .thenReturn(serviceProvider2);
		
		Assertions.assertDoesNotThrow(() -> serviceProviderRepository.findAll(Sort.by(Sort.Direction.ASC, "spRating")));
		
	}
	}
	
	
	
	
	@Nested 
	class TestUpdateServiceProviderById {
		
	@Test
	void testUpdateServiceProvider_Success() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		Optional<ServiceProvider> serviceProvider2 = Optional.of(serviceProvider);
		ServiceProvider serviceProvider3 = serviceProvider2.get();
        
			
			Mockito.when(serviceProviderRepository.findById(Mockito.anyInt()))
	          .thenReturn(serviceProvider2);
			Mockito.when(serviceProviderRepository.save(Mockito.anyObject()))
	          .thenReturn(serviceProvider);
			   
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.updateServiceProviderById(1,serviceProvider));
		}
	
	
	
	@Test
	void testUpdateServiceProvider_Failed() {
	
			ServiceProvider serviceProvider = new ServiceProvider();
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.updateServiceProviderById(10,serviceProvider));
			
		}
		
	}
	
	
	@Nested 
	class DeleteServiceProviderTest {
		
	@Test
	void testDeleteServiceProvider_Success() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		
		Optional<ServiceProvider> serviceProvider2 = Optional.of(serviceProvider);
		
			
			Mockito.when(serviceProviderRepository.findById(1))
	          .thenReturn(serviceProvider2);
			Mockito.doNothing().when(serviceProviderRepository).deleteById(1);
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.deleteServiceProviderById(1));
		}
	
	
	@Test
	void testDeleteServiceProvider_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.deleteServiceProviderById(1));
			
		}
		
	}
	
	@Nested 
	class GetEncryptedPasswordTest {
	
	@Test
	void TestgetEncryptedPassword() {
	
			
			Assertions.assertDoesNotThrow(() -> bCryptPasswordEncoder.encode("xyz"));
			
		}
		
	}
	
	
	
	@Nested
	class GetServicesByCategoryAndCityTest {
		
	@Test
	void getServicesByCategoryAndCity() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		
		List<String> services = null;
		Mockito.when(serviceProviderRepository.findServiceCities()).thenReturn(services);
		Assertions.assertDoesNotThrow(() -> serviceProviderService.getServiceCities());
		
	}
		
		
	}
	
	
	@Nested
	class ServiceCountResponseTest {
		
	@Test
	void getServiceCountResponse() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		
		List<Integer> services = null;
		Mockito.when(serviceProviderRepository.findServiceCount(Mockito.anyInt())).thenReturn(services);
		Assertions.assertDoesNotThrow(() -> serviceProviderService.getServiceCount(1));
		
	}
		
		
	}
	
	
	
	
	@Nested 
	class GetSPRatingsByIdTest {
		
	@Test
	void testGetSPRatingsById_Success() {
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderId(1);
		serviceProvider.setCompanyName("abc company");
		serviceProvider.setEmailId("abc@gmail.com");
		serviceProvider.setOwnerName("xyz");
		serviceProvider.setPhoneNum("1234567895");
		serviceProvider.setPassword("ggfhg");
		
		Optional<ServiceProvider> service2 = Optional.of(serviceProvider);
		
			
			Mockito.when(serviceProviderRepository.findById(1))
	          .thenReturn(service2);
			Mockito.when(serviceProviderRepository.save(Mockito.anyObject()))
	          .thenReturn(serviceProvider);
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.getSPRatingsById(1));
		}
	
	
	@Test
	void testGetSRatingsById_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> serviceProviderService.getSPRatingsById(1));
			
		}
		
	}
	
	
	@Nested
	class addServiceProviderCategoryTest {
		
		@Test
		void testAddServiceProvider_Success() {
			ServiceProvider serviceProvider = new ServiceProvider();
			serviceProvider.setServiceProviderId(1);
			serviceProvider.setCompanyName("abc company");
			serviceProvider.setEmailId("abc@gmail.com");
			serviceProvider.setOwnerName("xyz");
			serviceProvider.setPhoneNum("1234567895");
			serviceProvider.setPassword("ggfhg");
			Category category = null ;
			
			serviceProvider.setCategory((Set<Category>) category);
			
			Mockito.when(categoryService.getCategoryById(Mockito.anyInt()))
	          .thenReturn(category);
			
				Mockito.when(serviceProviderRepository.save(Mockito.anyObject()))
		          .thenReturn(serviceProvider);
				Map<String,Integer> serviceCategoryMap = null;
				Assertions.assertDoesNotThrow(() -> serviceProviderService.addServiceProviderCategory(serviceCategoryMap));
			}
		
		
		@Test
		void testAddServiceProvider_Failed() throws Exception{
		
				//ServiceProvider serviceProvider = new ServiceProvider();
				
				Assertions.assertThrows(Exception.class,() -> serviceProviderService.addServiceProviderCategory(null));
				
				
			}
	}
	
	
	@Nested
	class ServiceProviderReportTest {
		
		@Test
		void testAddServiceProvider_Success() {
			ServiceProvider serviceProvider = new ServiceProvider();
			serviceProvider.setServiceProviderId(1);
			serviceProvider.setCompanyName("abc company");
			serviceProvider.setEmailId("abc@gmail.com");
			serviceProvider.setOwnerName("xyz");
			serviceProvider.setPhoneNum("1234567895");
			serviceProvider.setPassword("ggfhg");
			Category category = new Category();
			Optional<ServiceProvider> sp=null;
			
			ServiceProvider spr = new ServiceProvider();
			spr.setBillings(null);

			
			
				Mockito.when(serviceProviderRepository.findById(Mockito.anyInt()))
		          .thenReturn(sp);
				Map<String,Integer> serviceCategoryMap = null;
				Assertions.assertDoesNotThrow(() -> serviceProviderService.getServiceProviderReport(1));
			}
		
		
		@Test
		void testAddServiceProvider_Failed() throws Exception{
		
				//ServiceProvider serviceProvider = new ServiceProvider();
				
				Assertions.assertThrows(Exception.class,() -> serviceProviderService.getServiceProviderReport(1));
				
				
			}
	}
	
	
	
}
