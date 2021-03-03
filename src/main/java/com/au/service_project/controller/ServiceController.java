package com.au.service_project.controller;


import com.au.service_project.entity.Service;
import com.au.service_project.service.ServiceProviderService;
import com.au.service_project.service.ServiceService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired 
    ServiceService serviceService;

    @Autowired
    ServiceProviderService serviceProviderService;

    @PostMapping("")
    public ResponseEntity<Object> addService(@RequestBody Service service){

        String response = serviceService.addService(service);
        if(response != null) {
            Map<String, Integer> serviceCategoryMap = new HashMap<>();
            serviceCategoryMap.put("serviceProviderId",service.getServiceProviderId());
            serviceCategoryMap.put("categoryId",service.getCategoryId());
            serviceProviderService.addServiceProviderCategory(serviceCategoryMap);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>("not able to create", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/image/{id}")
    public ResponseEntity<Object> handleImagePost(@PathVariable Integer id, @RequestParam("imagefile") MultipartFile file){

        String response = serviceService.saveImageFile(id, file);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("not able to add image", HttpStatus.BAD_REQUEST);
    }

     
    
    @GetMapping("/id/{serviceId}")
    public ResponseEntity<Object> getServiceById(@PathVariable("serviceId") Integer serviceId){
    	Service service = serviceService.getServiceById(serviceId);
        if(service != null)
            return new ResponseEntity<>(service, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to find service", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/name/{serviceName}")
    public ResponseEntity<Object> getServiceByName(@PathVariable("serviceName") String serviceName){
    	Service service = serviceService.getServiceByName(serviceName);
        if(service != null)
            return new ResponseEntity<>(service, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to find service", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/image/{serviceId}")
    public String renderImageFromDB(@PathVariable Integer serviceId, HttpServletResponse response) throws IOException {
        Service service =serviceService.getServiceById(serviceId);
        if (service != null && service.getServicePic()!=null) {
            byte[] byteArray = new byte[service.getServicePic().length];
            int i = 0;

            for (Byte wrappedByte : service.getServicePic()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
            return "image found";
        }
        else
            return "no image";
    }
    //
    
    @PutMapping("/id/{serviceId}")
    public ResponseEntity<Object> updateServiceById(@PathVariable("serviceId") Integer serviceId, @RequestBody Service service){
        Service serviceResponse = serviceService.updateServiceById(serviceId,service);
        if(serviceResponse != null)
            return new ResponseEntity<>(serviceResponse, HttpStatus.FOUND);
        else
            return new ResponseEntity<>("not able to update Service", HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/name/{serviceName}")
    public ResponseEntity<Object> updateServiceByName(@PathVariable("serviceName") String serviceName, @RequestBody Service service){
        Service serviceResponse = serviceService.updateServiceByName(serviceName,service);
        if(serviceResponse != null)
            return new ResponseEntity<>(serviceResponse, HttpStatus.FOUND);
        else
            return new ResponseEntity<>("not able to update Service", HttpStatus.BAD_REQUEST);

    }
    
    
    @DeleteMapping("/id/{ServiceId}")
    public ResponseEntity<Object> deleteServiceById(@PathVariable("ServiceId") Integer serviceId){
    	String response= serviceService.deleteServiceById(serviceId);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        else
            return new ResponseEntity<>("not able to delete Service", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/name/{ServiceName}")
    public ResponseEntity<Object> deleteServiceByName(@PathVariable("ServiceName") String serviceName){
    	String response= serviceService.deleteServiceByName(serviceName);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        else
            return new ResponseEntity<>("not able to delete Service", HttpStatus.BAD_REQUEST);

    }
    
    // Queries
    
    @GetMapping("/sratings/{serviceId}")
    public ResponseEntity<Object> getSRatingsById(@PathVariable("serviceId") Integer serviceId){
    	Double sRatings = serviceService.getSRatingsById(serviceId);
    	if(sRatings != null)
            return new ResponseEntity<>(sRatings, HttpStatus.FOUND);
        else
            return new ResponseEntity<>("not able to rate service", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{categoryId}/{cityName}")
    public ResponseEntity<Object> getServicesByCategoryAndCity(@PathVariable("categoryId") Integer categoryId,@PathVariable("cityName") String cityName){
        List<Service> serviceList = serviceService.getServicesByCategoryAndCity(categoryId,cityName);
        if(serviceList != null)
            return new ResponseEntity<>(serviceList, HttpStatus.FOUND);
        else
            return new ResponseEntity<>("not able to rate service", HttpStatus.BAD_REQUEST);
    }


    } 


