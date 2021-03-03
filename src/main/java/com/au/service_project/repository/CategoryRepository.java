package com.au.service_project.repository;

import com.au.service_project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    public Optional<Category> findCategoryByCategoryName(String s);


    @Query("SELECT categoryName FROM Category")
    public List<String> findAllNames();

    @Query("SELECT sp.serviceProviderId FROM ServiceProvider sp WHERE sp.serviceAddress.city= ?1 ")
    public Set<Integer> getCategoryByCity(String city);
    
    
}

