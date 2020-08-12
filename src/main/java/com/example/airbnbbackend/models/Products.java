package com.example.airbnbbackend.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Long price;
    private boolean status;

    @OneToOne
    private Details details;

    @ManyToOne
    private Accounts accounts;
}
