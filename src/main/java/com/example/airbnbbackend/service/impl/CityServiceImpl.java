package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.City;
import com.example.airbnbbackend.repositories.CityRepository;
import com.example.airbnbbackend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public City findCityByName(String name) {
        return cityRepository.findByNameCity(name);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }
}
