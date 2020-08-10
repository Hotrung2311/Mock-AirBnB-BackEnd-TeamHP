package com.example.airbnbbackend.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

}
