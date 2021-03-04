package com.au.service_project.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.au.service_project.response.ServiceCountResponse;
import com.au.service_project.response.ServiceProviderReport;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.au.service_project.entity.ServiceProvider;
import com.au.service_project.service.ServiceProviderService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/serviceprovider")
public class ServiceProviderController {

    @Autowired
    ServiceProviderService serviceProviderService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("")
    public ResponseEntity<Object> addServiceProvider(@RequestBody ServiceProvider serviceProvider)
    {

        String response=serviceProviderService.addServiceProvider(serviceProvider);
        if(response != null)
            return new ResponseEntity<>(serviceProvider, HttpStatus.OK);
        else
            return new ResponseEntity<>("Service Provider already exists, create a new one", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/image/{id}")
    public ResponseEntity<Object> handleImagePost(@PathVariable Integer id, @RequestParam("imagefile") MultipartFile file){

        String response = serviceProviderService.saveImageFile(id, file);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to add image", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getServiceProviderAll(){
        List<ServiceProvider> serviceProviders = serviceProviderService.getServiceProviderAll();
        if(serviceProviders != null)
            return new ResponseEntity<>(serviceProviders, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able list service providers", HttpStatus.BAD_REQUEST);

    }



    @GetMapping("/id/{serviceProviderId}")
    public ResponseEntity<Object> getServiceProvider(@PathVariable Integer serviceProviderId){
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(serviceProviderId);
        if(serviceProvider != null)
            return new ResponseEntity<>(serviceProvider, HttpStatus.OK);
        else
            return new ResponseEntity<>("No such Service Provider", HttpStatus.BAD_REQUEST);


    }
    
    @GetMapping("/email/{serviceProviderEmailId}")
    public ResponseEntity<Object> getServiceProviderByEmail(@PathVariable("serviceProviderEmailId") String serviceProviderEmailId){
    	ServiceProvider serviceProvider = serviceProviderService.getServiceProviderByEmail(serviceProviderEmailId);
        if(serviceProvider != null)
            return new ResponseEntity<>(serviceProvider, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to get customer", HttpStatus.BAD_REQUEST);

    }
    @GetMapping("report/{serviceProviderId}")
    public ResponseEntity<Object> getServiceProviderReport(@PathVariable Integer serviceProviderId){
        ServiceProviderReport serviceProviderReport = serviceProviderService.getServiceProviderReport(serviceProviderId);
        if(serviceProviderReport != null)
            return new ResponseEntity<>(serviceProviderReport, HttpStatus.OK);
        else
            return new ResponseEntity<>("No such Service Provider", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/image/{serviceProviderId}")
    public String renderImageFromDB(@PathVariable Integer serviceProviderId, HttpServletResponse response) throws IOException {
        ServiceProvider serviceProvider =serviceProviderService.getServiceProviderById(serviceProviderId);
        if (serviceProvider != null && serviceProvider.getServiceProviderPic()!=null) {
            byte[] byteArray = new byte[serviceProvider.getServiceProviderPic().length];
            int i = 0;

            for (Byte wrappedByte : serviceProvider.getServiceProviderPic() ){
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


    @PutMapping("/id/{serviceProviderId}")
    public ResponseEntity<Object> putServiceProvider(@PathVariable Integer serviceProviderId, @RequestBody ServiceProvider serviceProvider) {
        ServiceProvider serviceProviderResponse = serviceProviderService.updateServiceProviderById(serviceProviderId , serviceProvider);
        if(serviceProviderResponse != null)
            return new ResponseEntity<>(serviceProviderResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>("Could not update Service Provider Details", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/id/{serviceProviderId}")
    public ResponseEntity<Object> deleteServiceProviderById(@PathVariable Integer serviceProviderId){
        String response=serviceProviderService.deleteServiceProviderById(serviceProviderId);

        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("Could not delete the Service Provider", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/login")
    public ResponseEntity<Object> customerLogin(@RequestBody Map<String,String> loginMap ){
        System.out.println(loginMap.get("emailId"));
        System.out.println(loginMap.get("password"));


        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderByEmail(loginMap.get("emailId"));
        if(serviceProvider!=null){
            if(bCryptPasswordEncoder.matches(loginMap.get("password"), serviceProvider.getPassword())) {
                return new ResponseEntity<>(serviceProvider,HttpStatus.OK);
            }
            return new ResponseEntity<>("Wrong Password",HttpStatus.UNAUTHORIZED);
        }
        else
            return new ResponseEntity<>("No user",HttpStatus.NOT_FOUND);


    }

    @PostMapping("/category/")
    public ResponseEntity<Object> addServiceProviderCategory(@RequestBody Map<String,Integer> serviceCategoryMap){
        String response = serviceProviderService.addServiceProviderCategory(serviceCategoryMap);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("Could not add Category", HttpStatus.BAD_REQUEST);
    }

// Queries
    
    @GetMapping("/spratings/{serviceProviderId}")
    public ResponseEntity<Object> getSRatingsById(@PathVariable("serviceProviderId") Integer serviceProviderId){
    	Double spRatings = serviceProviderService.getSPRatingsById(serviceProviderId);
    	if(spRatings != null)
            return new ResponseEntity<>(spRatings, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to rate service provider", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/servicecount/{serviceProviderId}")
    public ResponseEntity<Object> getServiceCount(@PathVariable("serviceProviderId") Integer serviceProviderId){
        ServiceCountResponse response = serviceProviderService.getServiceCount(serviceProviderId);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to cout service", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/cities")
    public ResponseEntity<Object> getServiceCities(){
        List<String > response = serviceProviderService.getServiceCities();
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to cout service", HttpStatus.BAD_REQUEST);
    }


    


}