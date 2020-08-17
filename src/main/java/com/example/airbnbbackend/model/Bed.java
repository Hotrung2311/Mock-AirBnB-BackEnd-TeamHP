package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
//
//@Entity
//@Data
public class Bed {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberPeople;
//    @ManyToOne
//    @JoinColumn(name = "bedroom_id")
//    private Bedroom bedroom;

}
