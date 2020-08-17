package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.repositories.HouseRepository;
import com.example.airbnbbackend.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;
    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public void save(House house) {
        houseRepository.save(house);
    }

    @Override
    public void delete(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public List<House> findAllHouse() {
        return houseRepository.findAllHouse();
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public Optional<House> findByAddress(String address) {
        return houseRepository.findByAddress(address);
    }
}
