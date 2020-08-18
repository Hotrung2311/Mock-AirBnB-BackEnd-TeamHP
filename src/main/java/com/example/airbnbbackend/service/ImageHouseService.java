package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.ImageHouse;
import org.springframework.stereotype.Service;

public interface ImageHouseService {
    ImageHouse findImageByName(String name);
    void save(ImageHouse imageHouse);
    Iterable<ImageHouse> findAll();

    ServiceResult createPicture(ImageHouse imageHouse);

    ServiceResult findAllImage();

    ServiceResult findById(Long id);

    ServiceResult deletePicture(Long id);

    ServiceResult updatePicture(ImageHouse imageHouse);
}
