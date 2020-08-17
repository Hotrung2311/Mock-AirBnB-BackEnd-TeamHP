package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.ImageHouse;

import java.util.List;
import java.util.Optional;

public interface ImageHouseService {
    List<ImageHouse> createImage(ImageHouse imageHouse);

    List<ImageHouse> findAll();

    Optional<ImageHouse> findById(Long id);

    void deleteImage(Long id);

    void save(ImageHouse imageHouse);
}
