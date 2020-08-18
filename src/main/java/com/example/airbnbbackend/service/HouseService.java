package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Account;
import com.example.airbnbbackend.model.Address;
import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.model.ImageHouse;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HouseService {
    List<House> findAll();

    void save(House house);

    void delete(Long id);

    List<House> findAllHouse(Long id);

    Optional<House> findById(Long id);

    Optional<House> findByAddress(Address address);


    // bang add

    ServiceResult createHouse(House house, String username);
    ServiceResult updateHouse(Long id, House house);
    ServiceResult updateHousePicture(Long id, List<ImageHouse> ImagesList, String hostname);
    ServiceResult findAllHouse();
    ServiceResult findHouseById(Long id);
    ServiceResult searchHouse(int bedroom, int bathroom, Long province_id);
    ServiceResult findAllByHost(String hostname);
}
