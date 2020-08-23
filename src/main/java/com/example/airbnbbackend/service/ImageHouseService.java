package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.ImageHouse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ImageHouseService {
    void save(ImageHouse imageHouse);
    Iterable<ImageHouse> findAll();
    List<ImageHouse> findAllByHouse_Id(Long id);

    // bang add
//    ServiceResult createImage(ImageHouse imageHouse);
//
//    ServiceResult findAll();
//
//    ServiceResult findById(Long id);
//
//    ServiceResult deleteImage(Long id);
//
//    ServiceResult updateImage(ImageHouse imageHouse);
}
