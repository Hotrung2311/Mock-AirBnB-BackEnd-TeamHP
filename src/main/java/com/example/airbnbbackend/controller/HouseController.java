package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.*;
import com.example.airbnbbackend.service.AccountService;
import com.example.airbnbbackend.service.CommentService;
import com.example.airbnbbackend.service.HouseService;
import com.example.airbnbbackend.service.ImageHouseService;
import com.example.airbnbbackend.service.ServiceResult;
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
    private CommentService commentService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private ImageHouseService imageHouseService;

    @GetMapping("/")
    public ResponseEntity<?> getAllHouse(){
        List<House> houses =houseService.findAll();
        return ResponseEntity.ok(houses);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getHouseById( @PathVariable Long id){
        Optional<House> house = houseService.findById(id);
        if (house.isPresent()){
            HouseCommentVote houseCommentVote = new HouseCommentVote();
            houseCommentVote.setAccount(house.get().getAccount());
            houseCommentVote.setAddress(house.get().getAddress());
            houseCommentVote.setBathroom(house.get().getBathroom());
            houseCommentVote.setBedroom(house.get().getBedroom());
            houseCommentVote.setCity(house.get().getCity());
            houseCommentVote.setHouseType(house.get().getHouseType());
            houseCommentVote.setId(house.get().getId());
            houseCommentVote.setNameHouse(house.get().getNameHouse());
            houseCommentVote.setPriceHouse(house.get().getPriceHouse());
            houseCommentVote.setRoomType(house.get().getRoomType());
            houseCommentVote.setVoteNumber(house.get().getVoteNumber());
            List<Comment> comments = commentService.findByHouse_Id(house.get().getId());
            houseCommentVote.setComments(comments);
            return ResponseEntity.ok(houseCommentVote);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createHouse(@RequestBody House house){
        Optional<House> house1 = houseService.findByAddress(house.getAddress());
        if (house1.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            Optional<Account> account = accountService.findById(house.getAccount().getId());
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
            Optional<House> house2 = houseService.findByAddress(house.getAddress());
            if (house2.isPresent()){
                for (int i =0; i<house.getImageHouses().size(); i++){
                    house.getImageHouses().get(i).setHouse(house2.get());
                    imageHouseService.save(house.getImageHouses().get(i));
                }
            }
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
