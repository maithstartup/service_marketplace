package com.au.service_project.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

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
import org.springframework.web.multipart.MultipartFile;

import com.au.service_project.entity.Address;
import com.au.service_project.entity.Category;
import com.au.service_project.impl.CategoryServiceImpl;


@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
	
	@InjectMocks
	CategoryController categoryController;
	@Mock
	CategoryServiceImpl categoryService;
	
	@Nested
	class AddCategoryTest { 
	
	@Test
	void testAddCategory_Success() {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("abbas");
		category.setCategoryPic(null);
		category.setServices(null);
		Mockito.when(categoryService.addCategory(Mockito.anyObject()))
        .thenReturn("Created Succesfully");
		
		ResponseEntity<Object> response = categoryController.addCategory(category);
		
		Assertions.assertNotNull(response);
		Assertions.assertDoesNotThrow(() -> categoryController.addCategory(category));
		
		
	}
	@Test
	void testAddCategory_Failed() {
		Category category=new Category();
		Mockito.when(categoryService.addCategory(Mockito.anyObject()))
        .thenReturn(null);
		
		ResponseEntity<Object> response = categoryController.addCategory(category);
		Assertions.assertNotNull(response);
	}
}

	@Nested
	class GetCategoryAllNameTest{
		@Test
		void testGetCategoryAllName_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("xyz");
			category.setCategoryPic(null);
			category.setServices(null); 
			List<String> category2=null;
			List<String> categorySet = categoryService.getCategoryAllName();
			categorySet.add("xyz");
			
			Mockito.when(categoryService.getCategoryAllName())
	        .thenReturn(categorySet);
			List<String> response = categoryService.getCategoryAllName();
			Assertions.assertDoesNotThrow(() -> categoryController.getCategoryAllName());
		}
		
		
		@Test
		void testGetCategoryAllName_Failed() {
			Mockito.when(categoryService.getCategoryAllName())
	        .thenReturn(null);
			List<String> response = categoryService.getCategoryAllName();
			Assertions.assertDoesNotThrow(() -> categoryController.getCategoryAllName());
				}
	}
	
	
	@Nested
	class GetCategoryAllTest{
		@Test
		void testGetCategoryAll_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			List<Category> category2 = null;
			List<Category> categorySet = categoryService.getCategoryAll();
			categorySet.add(category);
			
			Mockito.when(categoryService.getCategoryAll())
	        .thenReturn(categorySet);
			ResponseEntity<Object> response = categoryController.getCategoryAll();
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> categoryController.getCategoryAll());
		}
		
		
		@Test
		void testGetCategoryAll_Failed() {
			Mockito.when(categoryService.getCategoryAll())
	        .thenReturn(null);
			ResponseEntity<Object> response = categoryController.getCategoryAll();
			Assertions.assertNotNull(response);
		}
	}
	
	
	@Nested
	class HandleImagePostTest{
		@Test
		void testHandleImagePost_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("xyz");
			category.setCategoryPic(null);
			category.setServices(null); 
			List<String> category2=null;
			List<String> categorySet = categoryService.getCategoryAllName();
			categorySet.add("xyz");
			String image="Image Added";
			MultipartFile file = null;
			Mockito.when(categoryService.saveImageFile(Mockito.anyInt(), Mockito.any()))
	        .thenReturn(image);
			Assertions.assertDoesNotThrow(() -> categoryController.handleImagePost(1,file));
		}
		
		
		@Test
		void testGetCategoryAllName_Failed() {
			List<String> response = categoryService.getCategoryAllName();
			Assertions.assertDoesNotThrow(() -> categoryController.handleImagePost(1,null));
				}
	}
	
	@Nested
	class GetCategoryByIdTest{
		@Test
		void testGetCategoryById_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			Mockito.when(categoryService.getCategoryById(Mockito.anyInt()))
	        .thenReturn(category);
			Category response = categoryService.getCategoryById(1);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->  categoryController.getCategoryById(1));
		}
		
		
		@Test
		void testGetCategoryById_Failed() {
			Assertions.assertDoesNotThrow(() ->  categoryController.getCategoryById(1));
				}
	}
	
	@Nested
	class GetCategoryByNameTest{
		@Test
		void testGetCategoryByName_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			Mockito.when(categoryService.getCategoryByName(Mockito.anyString()))
	        .thenReturn(category);
			Category response = categoryService.getCategoryByName("abbas");
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->  categoryController.getCategoryByName("abbas"));
		}
		
		
		@Test
		void testGetCategoryByName_Failed() {
			Category category=new Category();
			Mockito.when(categoryService.getCategoryByName(Mockito.anyString()))
	        .thenReturn(null);
			Category response = categoryService.getCategoryByName("abbas");
			Assertions.assertDoesNotThrow(() ->  categoryController.getCategoryByName("abbas"));
			}
	}
	
	/////////////////////////////////////////////////////////////////////////
	@Nested
	class RenderImageFromDBTest{
		@Test
		void testRenderImageFromDB_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null);
			byte[] byteArray = new byte[5];
            int i = 0;

			Mockito.when(categoryService.getCategoryById(Mockito.anyInt()))
	        .thenReturn(category);
		
			Assertions.assertDoesNotThrow(() ->  categoryController.renderImageFromDB(1, null ));
		}
		
		
		@Test
		void testRenderImageFromDB_Failed() {
			Assertions.assertDoesNotThrow(() ->  categoryController.renderImageFromDB(1,null));
			}
	}
	
	
	
	
	
	
	
	@Nested
	class UpdateCategoryByIdTest{
		@Test
		void testUpdateCategoryById_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			Mockito.when(categoryService.updateCategoryById(Mockito.anyInt(), Mockito.anyObject()))
	        .thenReturn(category);
			ResponseEntity<Object> response = categoryController.updateCategoryById(1, category);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->   categoryController.updateCategoryById(1, category));
		}
		
		
		@Test
		void testUpdateCategoryById_Failed() {
			Category category=new Category();
			Mockito.when(categoryService.updateCategoryById(Mockito.anyInt(), Mockito.anyObject()))
	        .thenReturn(null);
			ResponseEntity<Object> response = categoryController.updateCategoryById(1, category);
			Assertions.assertNotNull(response);
		}
	}
	@Nested
	class UpdateCategoryByNameTest{
		@Test
		void testUpdateCategoryByName_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			Mockito.when(categoryService.updateCategoryByName(Mockito.anyString(), Mockito.anyObject()))
	        .thenReturn(category);
			ResponseEntity<Object> response = categoryController.updateCategoryByName("abbas", category);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->   categoryController.updateCategoryByName("abbas", category));
		}
		
		
		@Test
		void testUpdateCategoryByName_Failed() {
			Category category=new Category();
			Mockito.when(categoryService.updateCategoryByName(Mockito.anyString(), Mockito.anyObject()))
	        .thenReturn(null);
			ResponseEntity<Object> response = categoryController.updateCategoryByName("abbas", category);
			Assertions.assertNotNull(response);
		}
	}
	@Nested
	class DeleteCategoryByIdTest{
		@Test
		void testDeleteCategoryById_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			Mockito.when(categoryService.deleteCategoryById(Mockito.anyInt()))
	        .thenReturn("Deleted the Category");
			ResponseEntity<Object> response = categoryController.deleteCategoryById(1);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->   categoryController.deleteCategoryById(1));
		}
		
		
		@Test
		void testDeleteCategoryById_Failed() {
			Category category=new Category();
			Mockito.when(categoryService.deleteCategoryById(Mockito.anyInt()))
	        .thenReturn(null);
			ResponseEntity<Object> response = categoryController.deleteCategoryById(1);
			Assertions.assertNotNull(response);
		}
	}
	@Nested
	class DeleteCategoryByNameTest{
		@Test
		void testDeleteCategoryByName_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			Mockito.when(categoryService.deleteCategoryByName(Mockito.anyString()))
	        .thenReturn("Deleted the Category");
			ResponseEntity<Object> response = categoryController.deleteCategoryByName("abbas");
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() ->  categoryController.deleteCategoryByName("abbas"));
		}
		
		
		@Test
		void testDeleteCategoryByName_Failed() {
			Category category=new Category();
			Mockito.when(categoryService.deleteCategoryByName(Mockito.anyString()))
	        .thenReturn(null);
			ResponseEntity<Object> response = categoryController.deleteCategoryByName("abbas");
			Assertions.assertNotNull(response);
	}
	
	}
	
	
	@Nested
	class GetCategoryByCityTest{
		@Test
		void testGetCategoryByCity_Success() {
			Category category=new Category();
			category.setCategoryId(1);
			category.setCategoryName("abbas");
			category.setCategoryPic(null);
			category.setServices(null); 
			Address address=new Address();
			address.setAddressId(1);
			address.setCity("hyd");
			Set<String> categories= categoryService.getCategoryByCity("abbas");
			Mockito.when(categoryService.getCategoryByCity(Mockito.anyString()))
	        .thenReturn(categories);
			
			Assertions.assertNotNull(categories);
			Assertions.assertDoesNotThrow(() ->  categoryController.getCategoryByCity("abbas"));
		}
		
		 
		@Test
		void testGetCategoryByCity_Failed() { 
			Category category=new Category();
			Set<String> response = categoryService.getCategoryByCity("abbas");
			Mockito.when(categoryService.getCategoryByCity(Mockito.anyString()))
	        .thenReturn(null);
			
			Assertions.assertDoesNotThrow(() ->  categoryController.getCategoryByCity("abbas"));
			}
	}
}
