package com.au.service_project.repository;

import com.au.service_project.entity.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ServiceRepository extends JpaRepository<Service,Integer> {
	public Optional<Service> findServiceByServiceName(String s);
	
	@Query("SELECT AVG(transactionRating) FROM Transaction t WHERE t.serviceId = ?1 GROUP BY t.serviceId ")
	public Double findServiceRatings(Integer serviceId);

//	@Query("SELECT services from ServiceProvider sp where sp.serviceAddress.city=?1")
	@Query("SELECT s FROM Service s join ServiceProvider sp on s.serviceProviderId=sp.serviceProviderId where s.categoryId=?1 AND sp.serviceAddress.city=?2")
	public List<Service> findServicesByCategoryAndCity(Integer categoryId , String cityName);
	
	
}



