package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.ImageHouse;
import com.example.airbnbbackend.repositories.ImageHouseRepository;
import com.example.airbnbbackend.service.ImageHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageHouseService {

    @Autowired
    private ImageHouseRepository imageHouseRepository;


    @Override
    public List<ImageHouse> createImage(ImageHouse imageHouse) {
        return null;
    }

    @Override
    public List<ImageHouse> findAll() {
        return null;
    }

    @Override
    public Optional<ImageHouse> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteImage(Long id) {

    }

    @Override
    public void save(ImageHouse imageHouse) {

    }
}
