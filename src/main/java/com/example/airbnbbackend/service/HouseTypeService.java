package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.HouseType;

public interface HouseTypeService {

    ServiceResult createHouseType(HouseType houseType);

    ServiceResult findAll();

    ServiceResult findById(Long id);

    ServiceResult deleteHouseType(Long id);

    ServiceResult updateHouseType(HouseType houseType);
}