package com.au.service_project.impl;

import com.au.service_project.entity.Address;
import com.au.service_project.repository.AddressRepository;
import com.au.service_project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    public String addAddress(Address address){
        try{
            addressRepository.save(address);
            return "address added";
        }
        catch (Exception e)
        {
            return null;
        }

    }
    public Address updateAddressById(Integer addressId , Address address){
           Optional<Address> address1 = addressRepository.findById(addressId);
           if(address1.isPresent())
           {  Address  address2=address1.get();
               address2.setHouseAddress(address.getHouseAddress());
               address2.setArea(address.getArea());
               address2.setCity(address.getCity());
               address2.setPincode(address.getPincode());
               address2.setState(address.getState());
               address2.setCountry(address.getCountry());
               addressRepository.save(address2);
               return address2;
           }
           return null;

    }
}
