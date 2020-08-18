package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.ImageHouse;
import com.example.airbnbbackend.repositories.ImageHouseRepository;
import com.example.airbnbbackend.service.ImageHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageHouseService {
    @Autowired
    private ImageHouseRepository imageHouseRepository;
    @Override
    public ImageHouse findImageByName(String name) {
        return imageHouseRepository.findRoleByImageName(name);
    }

    @Override
    public void save(ImageHouse imageHouse) {
        imageHouseRepository.save(imageHouse);
    }

    @Override
    public Iterable<ImageHouse> findAll() {
        return imageHouseRepository.findAll();
    }
}
