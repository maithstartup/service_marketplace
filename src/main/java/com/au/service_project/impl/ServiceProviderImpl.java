package com.au.service_project.impl;

import java.util.*;

import com.au.service_project.entity.*;
import com.au.service_project.response.ServiceCountResponse;
import com.au.service_project.response.ServiceProviderReport;
import com.au.service_project.service.CategoryService;
import com.au.service_project.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.au.service_project.repository.ServiceProviderRepository;
import com.au.service_project.service.ServiceProviderService;
import org.springframework.web.multipart.MultipartFile;


@org.springframework.stereotype.Service
public class ServiceProviderImpl  implements ServiceProviderService{
    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public String addServiceProvider(ServiceProvider serviceProvider){

        try {
            String plainPassword = serviceProvider.getPassword();
            String encryptedPassword = getEncryptedPassword(plainPassword);
            serviceProvider.setPassword(encryptedPassword);

            serviceProviderRepository.save(serviceProvider);
            return "Created Service Provider Succesfully";
        }
        catch(Exception e)
        {
            return null;
        }

    }

    public String saveImageFile(Integer serviceProviderId, MultipartFile file) {
        try {
            ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderId).get();

//            Byte[] byteObjects = new Byte[file.getBytes().length];
            byte[] byteObjects = file.getBytes();

//            int i = 0;
//
//            for (byte b : file.getBytes()) {
//                byteObjects[i++] = b;
//            }

            serviceProvider.setServiceProviderPic(byteObjects);
            serviceProviderRepository.save(serviceProvider);
            return "Image Added";
        } catch (Exception e) {
            //todo handle better

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ServiceProvider getServiceProviderById(Integer serviceProviderId) {
        Optional<ServiceProvider> serviceProvider = serviceProviderRepository.findById(serviceProviderId);
        if(serviceProvider.isPresent()) {
            return serviceProvider.get();
        }
        return null;
    }

     
    @Override
    public ServiceProvider getServiceProviderByEmail(String emailId) {
        Optional<ServiceProvider> serviceProvider = serviceProviderRepository.findServiceProviderByEmailId(emailId);
        if(serviceProvider.isPresent()) {
            return serviceProvider.get();
        }
        return null;
    }

    public List<ServiceProvider> getServiceProviderAll(){
       List<ServiceProvider> serviceProviders = serviceProviderRepository.findAll(Sort.by(Sort.Direction.ASC, "spRating"));
        return serviceProviders;

    }

    @Override
    public ServiceProvider updateServiceProviderById(Integer serviceProviderId, ServiceProvider serviceProvider) {
        Optional<ServiceProvider> serviceProvider2 = serviceProviderRepository.findById(serviceProviderId);
        if(serviceProvider2.isPresent()) {

            String plainPassword = serviceProvider.getPassword();
            String encryptedPassword = getEncryptedPassword(plainPassword);
            serviceProvider.setPassword(encryptedPassword);

            ServiceProvider serviceProvider3 = serviceProvider2.get();
            serviceProvider3.setPassword(encryptedPassword);
            serviceProvider3.setServiceAddress(serviceProvider.getServiceAddress());
            serviceProvider3.setSpRating(serviceProvider.getSpRating());


            return serviceProviderRepository.save(serviceProvider3);

        }


        return null;
    }

    @Override
    public String deleteServiceProviderById(Integer serviceProviderId) {
        Optional<ServiceProvider> serviceProvider2 = serviceProviderRepository.findById(serviceProviderId);
        if(serviceProvider2.isPresent()) {
            serviceProviderRepository.deleteById(serviceProviderId);
            return "Deleted the Service Provider";
        }

        return null;

    }

    public String addServiceProviderCategory(Map<String,Integer> serviceCategoryMap){


        Category category = categoryService.getCategoryById(serviceCategoryMap.get("categoryId"));
        ServiceProvider serviceProvider = getServiceProviderById(serviceCategoryMap.get("serviceProviderId"));
        if(serviceProvider!=null && category!=null) {
            Set<Category> categories = serviceProvider.getCategory();
            categories.add(category);
            serviceProvider.setCategory(categories);
            serviceProviderRepository.save(serviceProvider);
            return "Category Added";
        }
        return  null;
    }




    private String getEncryptedPassword(String plainPassword) {
        return bCryptPasswordEncoder.encode(plainPassword);
    }

    
    //Query
	@Override
	public Double getSPRatingsById(Integer serviceProviderId) {
		Optional<ServiceProvider> serviceProvider = serviceProviderRepository.findById(serviceProviderId);
		Double spRatings = serviceProviderRepository.findServiceProviderRatings(serviceProviderId);
        if(serviceProvider.isPresent()) {
        	ServiceProvider serviceProvider2 = serviceProvider.get();
        	serviceProvider2.setSpRating(spRatings);
        	serviceProviderRepository.save(serviceProvider2);
        	return spRatings;
        }
        return null;
	}

    public ServiceProviderReport getServiceProviderReport(Integer serviceProviderId){
        Optional<ServiceProvider> serviceProviderOptional = serviceProviderRepository.findById(serviceProviderId);
        if(serviceProviderOptional.isPresent()) {
            ServiceProviderReport serviceProviderReport= new ServiceProviderReport();
            ServiceProvider serviceProvider = serviceProviderOptional.get();
            serviceProviderReport.setServiceProviderId(serviceProviderId);
            serviceProviderReport.setTotalRevenue(serviceProviderRepository.findServiceProviderRevenue(serviceProviderId));
            serviceProviderReport.setTotalRevenueGst(serviceProviderRepository.findServiceProviderRevenueGst(serviceProviderId));
            if(serviceProvider.getBillings()!=null)
            serviceProviderReport.setNoOfBills(serviceProvider.getBillings().size());
            serviceProviderReport.setBillings(serviceProvider.getBillings());
            Set<Integer> customerIdSet =  serviceProviderRepository.findCustomerIdOfServiceProvider(serviceProviderId);
            serviceProviderReport.setCustomerIds(customerIdSet);
            serviceProviderReport.setServices(serviceProvider.getServices());

            serviceProviderReport.setCustomers(serviceProviderRepository.findCustomersOfServiceProvider(customerIdSet));

            if( serviceProvider.getServices() !=null)
                serviceProviderReport.setNoOfServices(serviceProvider.getServices().size());
           serviceProviderReport.setNoOfUniquesCustomers(serviceProviderRepository.findNoOfUniqueCustomers(serviceProviderId));
             return serviceProviderReport;
        }
        return null;
    }

    public ServiceCountResponse getServiceCount(Integer serviceProviderId){
        List<Integer>serviceList = serviceProviderRepository.findServiceCount(serviceProviderId);

        Service service= new Service();
        List<String> serviceNames=new ArrayList<>();
        List<Integer> serviceCounts=new ArrayList<>();;
        for (Integer serviceId : serviceList ){
            service = serviceService.getServiceById(serviceId);
            serviceNames.add(service.getServiceName());
            serviceCounts.add(service.getTransactions().size());
        }
        ServiceCountResponse serviceCountResponse=new ServiceCountResponse();
        serviceCountResponse.setServiceNames(serviceNames);
        serviceCountResponse.setTransactionCounts(serviceCounts);

        return serviceCountResponse;

    }

    public List<String > getServiceCities(){
        List<String> cities=serviceProviderRepository.findServiceCities();

        return cities;

    }



}