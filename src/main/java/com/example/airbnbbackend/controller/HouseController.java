package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @GetMapping("/")
    public ResponseEntity<?> getAllHouse(){
        List<House> houses =houseService.findAll();
        return ResponseEntity.ok(houses);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getHouseById( @PathVariable Long id){
        Optional<House> house = houseService.findById(id);
        return house.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createHouse(@RequestBody House house){
        Optional<House> house1 = houseService.findByAddress(house.getAddress());
        if (house1.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            houseService.save(house);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editHouse(@PathVariable Long id){
        Optional<House> house = houseService.findById(id);
        if (house.isPresent()){
            houseService.save(house.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHouse(@PathVariable Long id){
        Optional<House> house = houseService.findById(id);
        if (house.isPresent()){
            houseService.delete(house.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
