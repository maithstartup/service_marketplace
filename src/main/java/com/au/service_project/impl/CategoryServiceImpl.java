package com.au.service_project.impl;


import com.au.service_project.entity.Category;
import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.repository.CategoryRepository;
import com.au.service_project.service.CategoryService;
import com.au.service_project.service.ServiceProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    ServiceProviderService serviceProviderService;


    public String addCategory(Category category) {
        try {
            categoryRepository.save(category);
            return "Created Succesfully";
        } catch (Exception e) {
            return null;
        }
    }
    public String saveImageFile(Integer categoryId, MultipartFile file) {
        try {
            Category category = categoryRepository.findById(categoryId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            category.setCategoryPic(byteObjects);
            categoryRepository.save(category);
            return "Image Added";
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
    public List<Category> getCategoryAll(){

        List<Category> categorySet = categoryRepository.findAll(Sort.by(Sort.Direction.ASC,"categoryName"));
        return categorySet;

    }

    public List<String> getCategoryAllName(){
        List<String> categoryNames = categoryRepository.findAllNames();
        return categoryNames;
    }

    public Category getCategoryById(Integer categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()) {
            return category.get();
        }
        return null;
    }

    public Category getCategoryByName(String categoryName){
        Optional<Category> category=categoryRepository.findCategoryByCategoryName(categoryName);
        if(category.isPresent()) {
            return category.get();
        }
        return null;
    }

	@Override
	public Category updateCategoryById(Integer categoryId, Category category) {
		Optional<Category> category2 = categoryRepository.findById(categoryId);
		if(category2.isPresent()) {

			Category category3 = category2.get();
			
            category3.setServices(category.getServices());
           
            return categoryRepository.save(category3);

        }
        return null;

	}

	@Override
	public Category updateCategoryByName(String categoryName, Category category) {
		Optional<Category> category2 = categoryRepository.findCategoryByCategoryName(categoryName);
		if(category2.isPresent()) {

			Category category3 = category2.get();
            category3.setServices(category.getServices());
           
            return categoryRepository.save(category3);

        }
        return null;
	}

	@Override
	public String deleteCategoryById(Integer categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()) {
        	categoryRepository.deleteById(categoryId);
            return "Deleted the Category";
        }
		
		return null;
	}

	@Override
	public String deleteCategoryByName(String categoryName) {
		Optional<Category> category = categoryRepository.findCategoryByCategoryName(categoryName);
        if(category.isPresent()) {
        	categoryRepository.delete(category.get());
            return "Deleted the Category";
        }
		
		return null;
	}
	
	//query
	
	
	@Override
    public Set<String> getCategoryByCity(String city) {
        Set<Integer> spIds = categoryRepository.getCategoryByCity(city);;
        Set<String> categoryNames=new HashSet<>() ;
        ServiceProvider serviceProvider= new ServiceProvider();
        Set< Category> categories;
        if(spIds != null) {
            for(Integer spId:spIds) {
                System.out.println(spId);
                serviceProvider = serviceProviderService.getServiceProviderById(spId);
                categories=serviceProvider.getCategory();
                for (Category category:categories )
                {
                    categoryNames.add(category.getCategoryName());
                }

            }
            System.out.println(categoryNames);
            return categoryNames;
        }
        return null;
    }


}
