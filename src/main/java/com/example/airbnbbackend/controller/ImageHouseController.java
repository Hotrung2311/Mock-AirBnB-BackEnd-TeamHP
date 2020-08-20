//package com.example.airbnbbackend.controller;
//
//import com.example.airbnbbackend.model.ImageHouse;
//import com.example.airbnbbackend.service.ImageHouseService;
//import com.example.airbnbbackend.service.ServiceResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin("*")
//public class ImageHouseController {
//    @Autowired
//    private ImageHouseService imageHouseService;
//
//    @GetMapping
//    public ResponseEntity<ServiceResult> listImage() {
//        return new ResponseEntity<>(imageHouseService.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ServiceResult> getImageById(@PathVariable Long id){
//        return new ResponseEntity<>(imageHouseService.findById(id), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<ServiceResult> createImage(@RequestBody ImageHouse imageHouse){
//        return new ResponseEntity<>(imageHouseService.createImage(imageHouse), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ServiceResult> deleteImage(@PathVariable Long id){
//        return new ResponseEntity<>(imageHouseService.deleteImage(id), HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ServiceResult> updateImage(@RequestBody ImageHouse imageHouse){
//        return new ResponseEntity<>(imageHouseService.updateImage(imageHouse),HttpStatus.OK);
//    }
//}
