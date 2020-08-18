package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.enumm.ServiceStatus;
import com.example.airbnbbackend.model.City;
import com.example.airbnbbackend.repositories.CityRepository;
import com.example.airbnbbackend.service.CityService;
import com.example.airbnbbackend.service.ServiceResult;
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

    @Override
    public ServiceResult createCity(City city) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(cityRepository.save(city));
        return serviceResult;    }

    @Override
    public ServiceResult findAllCity() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(cityRepository.findAll());
        return serviceResult;    }

    @Override
    public ServiceResult findById(Long id) {
        ServiceResult serviceResult = new ServiceResult();
        City city = cityRepository.findById(id).orElse(null);
        if (city == null) {
            serviceResult.setMessage("Province Not Found");
        }
        serviceResult.setData(city);
        return serviceResult;    }

    @Override
    public ServiceResult deleteCity(Long id) {
        ServiceResult serviceResult = new ServiceResult();
        City city = cityRepository.findById(id).orElse(null);
        if (city == null) {
            serviceResult.setStatus(ServiceStatus.FAILED);
            serviceResult.setMessage("Province Not Found");
        } else {
            cityRepository.delete(city);
        }
        return serviceResult;    }

    @Override
    public ServiceResult updateCity(City city) {
        ServiceResult serviceResult = new ServiceResult();
        if (cityRepository.findById(city.getId()).isPresent()) {
            serviceResult.setMessage("Province not found");
        } else {
            serviceResult.setData(cityRepository.save(city));
        }
        return serviceResult;    }
}
