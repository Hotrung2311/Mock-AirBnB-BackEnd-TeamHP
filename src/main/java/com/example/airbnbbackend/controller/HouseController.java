package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.Account;
import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.model.Role;
import com.example.airbnbbackend.service.AccountService;
import com.example.airbnbbackend.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private AccountService accountService;
    @GetMapping("/")
    public ResponseEntity<?> getAllHouse(){
        List<House> houses =houseService.findAll();
        return ResponseEntity.ok(houses);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getHouseById( @PathVariable Long id){
        Optional<House> house = houseService.findById(id);
        if (house.isPresent()){
            return ResponseEntity.ok(house.get());
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createHouse(@RequestBody House house){
//        Optional<House> house1 = houseService.findByAddress(house.getAddress());
        Optional<Account> account = accountService.findById(house.getAccount().getId());
        if (account.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
//            Optional<Account> account = accountService.findById(house.getAccount().getId());
            List<Role> roles = account.get().getRoles();
            if (roles.size()==1){
                Role role = new Role();
                role.setId((long) 3);
                role.setName("host");
                roles.add(role);
                account.get().setRoles(roles);
                accountService.save(account.get());
            }
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
