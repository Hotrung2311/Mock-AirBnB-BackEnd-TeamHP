package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.City;
import com.example.airbnbbackend.service.ServiceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
//    City findCityByName(String name);
}
