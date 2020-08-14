package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String accountAddress;
    private String email;

    @OneToMany
    private List<Vote> votes;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<House> housesForRent;

}
