package com.au.service_project.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.au.service_project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.au.service_project.entity.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider ,Integer>{

	public Optional<ServiceProvider> findServiceProviderByEmailId(String emailId);

	@Query("SELECT SUM(cost) FROM Billing b WHERE b.serviceProviderId= ?1")
	public Float findServiceProviderRevenue(Integer serviceProviderId);

	@Query("SELECT SUM(totalCost) FROM Billing b WHERE b.serviceProviderId= ?1")
	public Float findServiceProviderRevenueGst(Integer serviceProviderId);


	@Query("SELECT COUNT(DISTINCT b.customerId) from Billing b WHERE b.serviceProviderId= ?1")
	public Integer findNoOfUniqueCustomers(Integer serviceProviderId);

	@Query("SELECT s.serviceId from Service s WHERE s.serviceProviderId= ?1")
	public List<Integer>  findServiceCount(Integer serviceProviderId);

	@Query("SELECT customerId FROM Billing b  WHERE b.serviceProviderId= ?1")
	public Set<Integer> findCustomerIdOfServiceProvider(Integer serviceProviderId);

	@Query("SELECT c from Customer c where c.customerId IN ?1")
	public Set<Customer> findCustomersOfServiceProvider(Set<Integer> customerList) ;

	@Query("SELECT AVG(serviceRatings) FROM Service s WHERE s.serviceProviderId = ?1 GROUP BY s.serviceProviderId ")
	public Double findServiceProviderRatings(Integer serviceProviderId);

	@Query("SELECT DISTINCT(a.city) FROM Address a join ServiceProvider s on a.addressId=s.serviceAddress")
	public List<String> findServiceCities();


}