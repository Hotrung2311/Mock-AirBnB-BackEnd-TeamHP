package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.ImageHouse;
import com.example.airbnbbackend.repositories.ImageHouseRepository;
import com.example.airbnbbackend.service.ImageHouseService;
import com.example.airbnbbackend.service.ServiceResult;
import com.example.airbnbbackend.service.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageHouseService {
    @Autowired
    private ImageHouseRepository imageHouseRepository;

    @Override
    public void save(ImageHouse imageHouse) {
        imageHouseRepository.save(imageHouse);
    }

    @Override
    public Iterable<ImageHouse> findAll() {
        return imageHouseRepository.findAll();
    }

//    @Override
//    public ServiceResult createImage(ImageHouse imageHouse) {
//        ServiceResult serviceResult = new ServiceResult();
//        serviceResult.setData(imageHouseRepository.save(imageHouse));
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult findAll() {
//        ServiceResult serviceResult = new ServiceResult();
//        serviceResult.setData(imageHouseRepository.findAll());
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult findById(Long id) {
//        ServiceResult serviceResult = new ServiceResult();
//        ImageHouse imageHouse = imageHouseRepository.findById(id).orElse(null);
//        if (imageHouse == null) {
//            serviceResult.setMessage("Picture Not Found");
//        }
//        serviceResult.setData(imageHouse);
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult deleteImage(Long id) {
//        ServiceResult serviceResult = new ServiceResult();
//        ImageHouse imageHouse = imageHouseRepository.findById(id).orElse(null);
//        if (imageHouse == null) {
//            serviceResult.setStatus(ServiceStatus.FAILED);
//            serviceResult.setMessage("Picture Not Found");
//        } else {
//            imageHouseRepository.delete(imageHouse);
//        }
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult updateImage(ImageHouse imageHouse) {
//        ServiceResult serviceResult = new ServiceResult();
//        if (! imageHouseRepository.findById(imageHouse.getId()).isPresent()) {
//            serviceResult.setMessage("Picture not found");
//        } else {
//            serviceResult.setData(imageHouseRepository.save(imageHouse));
//        }
//        return serviceResult;
//    }
}
