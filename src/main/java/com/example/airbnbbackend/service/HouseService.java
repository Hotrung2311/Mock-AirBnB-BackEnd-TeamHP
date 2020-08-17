package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.House;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    List<House> findAll();

    void save(House house);

    void delete(Long id);

    List<House> findAllHouse(Long id);

    Optional<House> findById(Long id);

    Optional<House> findByAddress(String address);
}
