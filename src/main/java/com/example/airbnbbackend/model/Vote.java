package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int vote;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;
}
