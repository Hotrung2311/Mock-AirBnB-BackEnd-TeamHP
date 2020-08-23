package com.example.airbnbbackend.model;

import lombok.Data;

import java.util.List;

@Data
public class HouseCommentVote {
    private Long id;
    private String address;
    private String nameHouse;
    private double voteNumber;
    private int bedroom;
    private int bathroom;
    private double priceHouse;
    String roomType;
    String houseType;
    private Account account;
    private String city;
    private List<Comment> comments;
    private List<ImageHouse> imageHouses;
}
