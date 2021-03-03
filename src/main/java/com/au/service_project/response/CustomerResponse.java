package com.au.service_project.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerResponse {
    private Integer customerId;

    private String firstName;

    private String lastName;

    private String emailId;

    private String phoneNum;

    public CustomerResponse(Integer customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
}
