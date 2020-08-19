package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ImageHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imageUrl;
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;
}
