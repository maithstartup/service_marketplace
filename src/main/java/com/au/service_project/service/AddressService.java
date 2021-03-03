package com.au.service_project.service;

import com.au.service_project.entity.Address;

public interface AddressService {

    public String addAddress(Address address);

    public Address updateAddressById(Integer addressId , Address address);
}
