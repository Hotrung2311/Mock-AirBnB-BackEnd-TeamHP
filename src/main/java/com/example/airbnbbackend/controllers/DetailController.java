package com.example.airbnbbackend.controllers;

import com.example.airbnbbackend.models.Details;
import com.example.airbnbbackend.services.detail.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/details")
public class DetailController {

    @Autowired
    DetailService detailService;

    @GetMapping
    public ResponseEntity<List<Details>> getAllDetail(){
        List<Details> detailsList = detailService.findAll();
        return new ResponseEntity<List<Details>>(detailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Details> getDetail(@PathVariable("id") Long id){
        Optional<Details> optionalDetails = detailService.findById(id);
        return optionalDetails.map(detail ->
                new ResponseEntity<Details>(detail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Details>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Details> createNewDetail(Details details){
        return new ResponseEntity<Details>(detailService.save(details), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Details> updateDetail(@PathVariable("id") Long id, Details details){
        Optional<Details> optionalDetails = detailService.findById(id);
        return optionalDetails.map(detail -> {
            details.setId(detail.getId());
            return new ResponseEntity<Details>(detailService.save(details), HttpStatus.OK);
        }).orElseGet(()-> new ResponseEntity<Details>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Details> deleteDetail(@PathVariable("id") Long id) {
        Optional<Details> optionalDetails = detailService.findById(id);
        return optionalDetails.map(details -> {
            detailService.remove(id);
            return new ResponseEntity<Details>(details, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<Details>(HttpStatus.NOT_FOUND));
    }
}
