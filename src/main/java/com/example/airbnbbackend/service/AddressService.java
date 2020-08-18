package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Address;

public interface AddressService {

    ServiceResult createAddress(Address address);

    ServiceResult findAll();

    ServiceResult findById(Long id);

    ServiceResult deleteAddress(Long id);

    ServiceResult updateAddress(Address address);
}
