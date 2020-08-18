package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.City;

public interface CityService {
    City findCityByName(String name);
    void save(City city);
    Iterable<City> findAll();


    ServiceResult createCity(City city);

    ServiceResult findAllCity();

    ServiceResult findById(Long id);

    ServiceResult deleteCity(Long id);

    ServiceResult updateCity(City city);
}
