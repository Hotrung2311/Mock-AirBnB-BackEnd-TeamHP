package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.ImageHouse;

public interface ImageHouseService {
    ImageHouse findImageByName(String name);
    void save(ImageHouse imageHouse);
    Iterable<ImageHouse> findAll();
}
