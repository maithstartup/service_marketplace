package com.au.service_project.service;

import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.response.ServiceCountResponse;
import com.au.service_project.response.ServiceProviderReport;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ServiceProviderService {

	public String addServiceProvider(ServiceProvider serviceProvider);

	public String saveImageFile(Integer serviceProviderId, MultipartFile file);

	public ServiceProvider getServiceProviderById(Integer serviceProviderId);

	public ServiceProviderReport getServiceProviderReport(Integer serviceProviderId);

	public ServiceProvider updateServiceProviderById(Integer serviceProviderId, ServiceProvider serviceProvider);

	public String deleteServiceProviderById(Integer serviceProviderId);

	public ServiceProvider getServiceProviderByEmail(String emailId);

	public String addServiceProviderCategory(Map<String,Integer> serviceCategoryMap);

	public List<ServiceProvider> getServiceProviderAll();

	public ServiceCountResponse getServiceCount(Integer serviceId);

	public List<String > getServiceCities();

	
	//query
	public Double getSPRatingsById(Integer serviceProviderId);

	


}