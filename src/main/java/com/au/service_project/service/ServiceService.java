package com.au.service_project.service;

import com.au.service_project.entity.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ServiceService {

    public String addService(Service service);

	public String saveImageFile(Integer serviceId, MultipartFile file);

    public Service getServiceById(Integer serviceId);

	public Service getServiceByName(String serviceName);

	public Service updateServiceById(Integer serviceId, Service service);

	public Service updateServiceByName(String serviceName, Service service);

	public String deleteServiceById(Integer serviceId);

	public String deleteServiceByName(String serviceName);
	
	//Query

	public Double getSRatingsById(Integer serviceId);

	public List<Service> getServicesByCategoryAndCity(Integer categoryId, String cityName);
	
	
	
	
}
