package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.HouseType;
import com.example.airbnbbackend.service.HouseTypeService;
import com.example.airbnbbackend.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/house-type")
public class HouseTypeController {
    @Autowired
    private HouseTypeService houseTypeService;

    @GetMapping
    public ResponseEntity<ServiceResult> listCategory() {
        return new ResponseEntity<>(houseTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(houseTypeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceResult> createCategory(@RequestBody HouseType houseType){
        return new ResponseEntity<>(houseTypeService.createHouseType(houseType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> deleteCategory(@PathVariable Long id){
        return new ResponseEntity<>(houseTypeService.deleteHouseType(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceResult> updateCategory(@RequestBody HouseType houseType){
        return new ResponseEntity<>(houseTypeService.updateHouseType(houseType),HttpStatus.OK);
    }
}