package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.City;
import com.example.airbnbbackend.service.CityService;
import com.example.airbnbbackend.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<ServiceResult> listCity() {
        return new ResponseEntity<>(cityService.findAllCity(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> getCityById(@PathVariable Long id){
        return new ResponseEntity<>(cityService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceResult> createCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.createCity(city), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> deleteCity(@PathVariable Long id){
        return new ResponseEntity<>(cityService.deleteCity(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceResult> updateCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.updateCity(city),HttpStatus.OK);
    }
}
