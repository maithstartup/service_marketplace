package com.au.service_project.request;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class AddressRequest {


    private String houseAddress;

    private String area;

    private String city;

    private String state;

    private String country;

    private Integer pincode;


}

