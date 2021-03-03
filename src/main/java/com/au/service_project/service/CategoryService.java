package com.au.service_project.service;

import com.au.service_project.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    public String addCategory(Category category);

    public List<Category> getCategoryAll();

    public List<String> getCategoryAllName();

    public String saveImageFile(Integer categoryId, MultipartFile file);

    public Category getCategoryById(Integer customerId);

    public Category getCategoryByName(String categoryName);

	public Category updateCategoryById(Integer categoryId, Category category);

	public Category updateCategoryByName(String categoryName, Category category);

	public String deleteCategoryById(Integer categoryId);

	public String deleteCategoryByName(String categoryName);
	
	//query

	public Set<String> getCategoryByCity(String city);
}
