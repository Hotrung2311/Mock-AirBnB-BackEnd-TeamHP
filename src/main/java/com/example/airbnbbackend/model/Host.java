package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
