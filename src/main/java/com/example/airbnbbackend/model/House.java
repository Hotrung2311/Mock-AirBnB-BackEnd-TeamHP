package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String nameHouse;
    private double voteNumber;
    private int numberBathroom;
    private double priceHouse;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Vote> votes;
    @OneToMany
    private List<Order> orders;
    @OneToMany
    private List<ImageHouse> imageHouses;
    @OneToMany
    private List<Bedroom> bedrooms;

}
