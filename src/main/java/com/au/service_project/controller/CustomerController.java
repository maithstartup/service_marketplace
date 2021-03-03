package com.au.service_project.controller;

import com.au.service_project.entity.Customer;
import com.au.service_project.service.CustomerService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService; 

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    static final String NOTFOUND ="not able to get customer";
    
    @PostMapping("")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer)
    {
        String plainPassword = customer.getPassword();
        String encryptedPassword = bCryptPasswordEncoder.encode(plainPassword);
        customer.setPassword(encryptedPassword);
        Customer response=customerService.addCustomer(customer);
        if(response != null)
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("not able to create", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/image/{id}")
    public ResponseEntity<Object> handleImagePost(@PathVariable Integer id, @RequestParam("imagefile") MultipartFile file){

        Customer response = customerService.saveImageFile(id, file);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to create images", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/id/{customerId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("customerId") Integer customerId){
        Customer customer = customerService.getCustomerById(customerId);
        if(customer != null)
            return new ResponseEntity<>(customer, HttpStatus.OK);
        else
            return new ResponseEntity<>(NOTFOUND, HttpStatus.BAD_REQUEST);

    }
    
    @GetMapping("/email/{customerEmailId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("customerEmailId") String customerEmailId){
        Customer customer = customerService.getCustomerByEmailId(customerEmailId);
        if(customer != null)
            return new ResponseEntity<>(customer, HttpStatus.OK);
        else
            return new ResponseEntity<>(NOTFOUND, HttpStatus.BAD_REQUEST);
 
    }
    @GetMapping("/billing/{customerId}")
    public ResponseEntity<Object> getCustomerBilling(@PathVariable("customerId") Integer customerId)
    {
        Customer customer = customerService.getCustomerById(customerId);
        if(customer != null)
            return new ResponseEntity<>(customer.getBillings(), HttpStatus.OK);
        else
            return new ResponseEntity<>(NOTFOUND, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/transaction/{customerId}")
    public ResponseEntity<Object> getCustomerTransaction(@PathVariable("customerId") Integer customerId)
    {
        Customer customer = customerService.getCustomerById(customerId);
        if(customer != null)
            return new ResponseEntity<>(customer.getTransactions(), HttpStatus.OK);
        else
            return new ResponseEntity<>(NOTFOUND, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/image/{customerId}")
    public String renderImageFromDB(@PathVariable Integer customerId, HttpServletResponse response) throws IOException {
        Customer customer =customerService.getCustomerById(customerId);
        if (customer != null && customer.getCustomerPic()!=null) {
            byte[] byteArray = new byte[customer.getCustomerPic().length];
            int i = 0;

            for (Byte wrappedByte : customer.getCustomerPic() ){
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
    @PutMapping("/id/{customerId}")
    public ResponseEntity<Object> updateCustomerById(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer){
    	Customer customerResponse = customerService.updateCustomerById(customerId,customer);
        if(customerResponse != null)
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to update customer", HttpStatus.BAD_REQUEST);

    }
    
    @DeleteMapping("/id/{customerId}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable("customerId") Integer customerId){
    	String response= customerService.deleteCustomerById(customerId);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to delete customer", HttpStatus.BAD_REQUEST);

    }


    @PostMapping("/login")
    public ResponseEntity<Object> customerLogin(@RequestBody Map<String,String> loginMap ){
        Customer customer = customerService.getCustomerByEmailId(loginMap.get("emailId"));
        if(customer!=null){
            if(bCryptPasswordEncoder.matches(loginMap.get("password"), customer.getPassword())) {
                return new ResponseEntity<>(customer,HttpStatus.OK);
            }
            return new ResponseEntity<>("Wrong Password",HttpStatus.UNAUTHORIZED);
        }
        else {
            return new ResponseEntity<>("No user", HttpStatus.NOT_FOUND);
        }
    }
}