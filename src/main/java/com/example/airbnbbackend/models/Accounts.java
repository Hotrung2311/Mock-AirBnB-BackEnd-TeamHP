package com.example.airbnbbackend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer age;
    private String address;
    private String IdNumber;
    private String passport;

    @ManyToMany
    private Set<Roles> roles;

}
