package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.model.Vote;
import com.example.airbnbbackend.service.HouseService;
import com.example.airbnbbackend.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class VoteController {
    @Autowired
    private VoteService voteService;
    @Autowired
    private HouseService houseService;
    @PostMapping("/vote/create")
    public ResponseEntity<?> voteHouse(@RequestBody Vote vote){
        Optional<Vote> vote1= voteService.findByAccount_id(vote.getAccount().getId());

        if (vote1.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            voteService.save(vote);
            List<Vote> votes = voteService.findByHouse_id(vote.getHouse().getId());
            double voteNumber;
            double sum = 0;
            for (Vote value : votes) {
                sum += value.getVote();
            }
            voteNumber=sum/votes.size();
            Optional<House> house = houseService.findById(vote.getHouse().getId());
            if (house.isPresent()){
                house.get().setVoteNumber(voteNumber);
                houseService.save(house.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
