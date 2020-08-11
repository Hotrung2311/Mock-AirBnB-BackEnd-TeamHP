package com.example.airbnbbackend.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @OneToOne
    private Products products;
}
