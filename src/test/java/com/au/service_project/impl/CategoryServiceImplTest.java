package com.au.service_project.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

import com.au.service_project.entity.Category;
import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.entity.Category;
import com.au.service_project.repository.CategoryRepository;
import com.au.service_project.service.ServiceProviderService;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

	@InjectMocks
	CategoryServiceImpl categoryService;
	
	@Mock
	CategoryRepository categoryRepository;

	@Mock
    ServiceProviderService serviceProviderService;

	
	@Nested 
	class AddCategoryTest {
		
	@Test
	void testAddCategory_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("abc");
		category.setCategoryPic(null);
		category.setServices(null);
		
			
			Mockito.when(categoryRepository.save(Mockito.anyObject()))
	          .thenReturn(category);
			
			Assertions.assertDoesNotThrow(() -> categoryService.addCategory(category));
		}
	
	
	@Test
	void testAddCategory_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> categoryService.addCategory(null));
			
		}
		
	}
	
	@Nested
	class SaveImageFileTest {
		
		@Test
		void testSaveImageFile_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abc");
			category.setCategoryPic(null);
			category.setServices(null);
			Optional<Category> category2 = Optional.of(category);
			
			Mockito.when(categoryRepository.findById(Mockito.anyInt()))
	          .thenReturn(category2);
				
			Mockito.when(categoryRepository.save(Mockito.anyObject()))
	          .thenReturn(category);
			Assertions.assertDoesNotThrow(() -> categoryService.saveImageFile(1,null));
				
		}
	
		@Test
		void testGetCategory_Failed() {
				Assertions.assertDoesNotThrow(() -> categoryService.saveImageFile(1,null));
			}
		
	}
	
	
	@Nested
	class GetCategoryAllTest {
		
	@Test
	void testGetCategoryAll() {
		List<Category> category = null;
		Mockito.when(categoryRepository.findAll(Sort.by(Sort.Direction.ASC,"categoryName")))
        .thenReturn(category);
		
		Assertions.assertDoesNotThrow(() -> categoryService.getCategoryAll());
		
	}
	}

	
	@Nested
	class GetCategoryAllName {
		
	@Test
	void testGetCategoryAll() {
		List<String> category = null;
		Mockito.when(categoryRepository.findAllNames()).thenReturn(category);
		Assertions.assertDoesNotThrow(() -> categoryService.getCategoryAllName());
		
	}
		
		
	}
	
	
	@Nested 
	class GetCategoryByIdTest {
		
	@Test
	void testGetCategoryById_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("abbas");
		category.setCategoryPic(null);
		category.setServices(null);
		
		Optional<Category> category2 = Optional.of(category);
		
			
			Mockito.when(categoryRepository.findById(Mockito.anyInt()))
	          .thenReturn(category2);
			
			Assertions.assertDoesNotThrow(() -> categoryService.getCategoryById(1));
		}
	
	
	@Test
	void testGetCategoryById_Failed() {
	
			Assertions.assertDoesNotThrow(() -> categoryService.getCategoryById(10));
			
		}
		
	}
	
	
	@Nested 
	class GetCategoryByNameTest {
		
	@Test
	void testGetCategoryByName_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("xyz");
		category.setCategoryPic(null);
		category.setServices(null);
		
		Optional<Category> category2 = Optional.of(category);
		
			
			Mockito.when(categoryRepository.findCategoryByCategoryName(Mockito.anyString()))
	          .thenReturn(category2);
			
			Assertions.assertDoesNotThrow(() -> categoryService.getCategoryByName("xyz"));
		}
	
	
	@Test
	void testGetCategoryByName_Failed() {
	
			Assertions.assertDoesNotThrow(() -> categoryService.getCategoryByName("xyz"));
			
		}
		
	}
	
		
	
	@Nested 
	class TestUpdateCategoryById {
		
	@Test
	void testUpdateCategory_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("xyz");
		category.setCategoryPic(null);
		category.setServices(null);
		
		Optional<Category> category2 = Optional.of(category);
		Category category3 = category2.get();
        //Category3.setGst((Category.getGst()!=null)? Category.getGst():Category3.getGst() );
       
			
			Mockito.when(categoryRepository.findById(Mockito.anyInt()))
	          .thenReturn(category2);
			Mockito.when(categoryRepository.save(Mockito.anyObject()))
	          .thenReturn(category);
			   
			
			Assertions.assertDoesNotThrow(() -> categoryService.updateCategoryById(1,category));
		}
	
	
	
	@Test
	void testUpdateCategory_Failed() {
	
			Category category=new Category();
			
			Assertions.assertDoesNotThrow(() -> categoryService.updateCategoryById(10,category));
			
		}
		
	}
	
	
	@Nested 
	class TestUpdateCategoryByName {
		
	@Test
	void testUpdateCategory_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("xyz");
		category.setCategoryPic(null);
		category.setServices(null);
		
		Optional<Category> category2 = Optional.of(category);
		Category category3 = category2.get();
        //Category3.setGst((Category.getGst()!=null)? Category.getGst():Category3.getGst() );
       
			
			Mockito.when(categoryRepository.findCategoryByCategoryName(Mockito.anyString()))
	          .thenReturn(category2);
			Mockito.when(categoryRepository.save(Mockito.anyObject()))
	          .thenReturn(category);
			   
			
			Assertions.assertDoesNotThrow(() -> categoryService.updateCategoryByName("xyz",category));
		}
	
	
	
	@Test
	void testUpdateCategory_Failed() {
	
			Category category=new Category();
			
			Assertions.assertDoesNotThrow(() -> categoryService.updateCategoryByName("xyz",category));
			
		}
		
	}
	
	
	
	
	
	
	
	@Nested 
	class DeleteCategoryByIdTest {
		
	@Test
	void testDeleteCategory_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("abbas");
		category.setCategoryPic(null);
		category.setServices(null);
		
		Optional<Category> Category2 = Optional.of(category);
		
			
			Mockito.when(categoryRepository.findById(1))
	          .thenReturn(Category2);
			Mockito.doNothing().when(categoryRepository).deleteById(1);
			
			Assertions.assertDoesNotThrow(() -> categoryService.deleteCategoryById(1));
		}
	
	
	@Test
	void testDeleteCategory_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> categoryService.deleteCategoryById(1));
			
		}
		
	}
	
	
	
	
	@Nested 
	class DeleteCategoryByNameTest {
		
	@Test
	void testDeleteCategory_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("xyz");
		category.setCategoryPic(null);
		category.setServices(null);
		
		Optional<Category> Category2 = Optional.of(category);
		
			
			Mockito.when(categoryRepository.findCategoryByCategoryName("xyz"))
	          .thenReturn(Category2);
			Mockito.doNothing().when(categoryRepository).delete(category);
			
			Assertions.assertDoesNotThrow(() -> categoryService.deleteCategoryByName("xyz"));
		}
	
	
	@Test
	void testDeleteCategory_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> categoryService.deleteCategoryByName("xyz"));
			
		}
		
	}
	
	
	
	
	@Nested 
	class TestGetCategoryByCity {
		
	@Test
	void testGetCategoryCostById_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("xyz");
		category.setCategoryPic(null);
		category.setServices(null);
		Integer spId =1;
		ServiceProvider serviceProvider = null;
		
		Optional<Category> Category2 = Optional.of(category);
		
			
			Mockito.when(categoryRepository.findById(Mockito.anyInt()))
	          .thenReturn(Category2);
			Mockito.when(categoryRepository.save(Mockito.anyObject()))
	          .thenReturn(category);
			Mockito.when(serviceProviderService.getServiceProviderById(Mockito.anyInt()))
	          .thenReturn(serviceProvider);
			
			//Mockito.doNothing().when(Category).setGst(Mockito.anyInt());
			   
			
			Assertions.assertDoesNotThrow(() -> categoryService.getCategoryByCity("xyz"));
		}
	
	@Test
	void testGetCategoryCostById_Success2() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("xyz");
		category.setCategoryPic(null);
		category.setServices(null);
		Integer spIds =null;
		ServiceProvider serviceProvider= new ServiceProvider();
        
		
		Optional<Category> Category2 = Optional.of(category);
		
			
			Mockito.when(categoryRepository.findById(Mockito.anyInt()))
	          .thenReturn(Category2);
			Mockito.when(categoryRepository.save(Mockito.anyObject()))
	          .thenReturn(category);
			Mockito.when(serviceProviderService.getServiceProviderById(Mockito.anyInt()))
	          .thenReturn(serviceProvider);
			
			//Mockito.doNothing().when(Category).setGst(Mockito.anyInt());
			   
			
			Assertions.assertDoesNotThrow(() -> categoryService.getCategoryByCity("xyz"));
		}
	
	
	@Test
	void testGetCategoryCostById_Failed() {
	
			
			Assertions.assertDoesNotThrow(() -> categoryService.getCategoryByCity(null));
			
		}
		
	}

}
