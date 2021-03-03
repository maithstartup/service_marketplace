package com.au.service_project.impl;

import com.au.service_project.entity.Service;
import com.au.service_project.repository.ServiceRepository;

import com.au.service_project.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;
   
    public String addService(Service service){ 

        serviceRepository.save(service);
 
    return "Success";
    }

	public String saveImageFile(Integer serviceId, MultipartFile file) {
		try {
			Optional<Service> serviceOptional = serviceRepository.findById(serviceId);
			Service service=new Service();
			if(serviceOptional.isPresent())
			{
				service=serviceOptional.get();
			}


			Byte[] byteObjects = new Byte[file.getBytes().length];

			int i = 0;

			for (byte b : file.getBytes()) {
				byteObjects[i++] = b;
			}

			service.setServicePic(byteObjects);
			serviceRepository.save(service);
			return "Image Added";
		} catch (Exception e) {

			return null;
		}
	}

    public Service getServiceById(Integer serviceId){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            return service.get();
        }
        return null;
    }
    
    //
    
    public Service getServiceByName(String serviceName){
        Optional<Service> service=serviceRepository.findServiceByServiceName(serviceName);
        if(service.isPresent()) {
            return service.get();
        }
        return null;
    }

	@Override
	public Service updateServiceById(Integer serviceId, Service service) {
		Optional<Service> service2 = serviceRepository.findById(serviceId);
		if(service2.isPresent()) {

			Service service3 = service2.get();
			service3.setCost((service.getCost() != null) ? service.getCost() : service3.getCost());
			service3.setDiscount((service.getDiscount() != null) ? service.getDiscount() : service3.getDiscount());
			service3.setDiscountAvailability(service.getDiscountAvailability() );
			service3.setDetails((service.getDetails() != null) ? service.getDetails() : service3.getDetails());
			service3.setWarranty((service.getWarranty() != null) ? service.getWarranty() : service3.getWarranty());
			
            return serviceRepository.save(service3);

        }
        return null;

	}

	@Override
	public Service updateServiceByName(String serviceName, Service service) {
		Optional<Service> service2 = serviceRepository.findServiceByServiceName(serviceName);
		if(service2.isPresent()) {

			Service service3 = service2.get();
			service3.setCost((service.getCost() != null) ? service.getCost() : service3.getCost());
			service3.setDiscount((service.getDiscount() != null) ? service.getDiscount() : service3.getDiscount());
			service3.setDiscountAvailability( service.getDiscountAvailability());
			service3.setDetails((service.getDetails() != null) ? service.getDetails() : service3.getDetails());
			service3.setWarranty((service.getWarranty() != null) ? service.getWarranty() : service3.getWarranty());
			
			return serviceRepository.save(service3);

        }
        return null;
	}

	@Override
	public String deleteServiceById(Integer serviceId) {
		Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
        	serviceRepository.deleteById(serviceId);
            return "Deleted the Service";
        }
		
		return null;
	}

	@Override
	public String deleteServiceByName(String serviceName) {
		Optional<Service> service = serviceRepository.findServiceByServiceName(serviceName);
        if(service.isPresent()) {
        	serviceRepository.delete(service.get());
            return "Deleted the Service";
        }
		
		return null;
	}

	//Query
	
	@Override
	public Double getSRatingsById(Integer serviceId) {
		Optional<Service> service = serviceRepository.findById(serviceId);
		Double sRatings = serviceRepository.findServiceRatings(serviceId);
        if(service.isPresent()) {
        	Service service2 = service.get();
        	service2.setServiceRatings(sRatings);
        	serviceRepository.save(service2);
        	return sRatings;
        }
        return null;
   }

	public List<Service> getServicesByCategoryAndCity(Integer categoryId, String cityName){

    	return serviceRepository.findServicesByCategoryAndCity(categoryId,cityName);

	}

    
    

}
