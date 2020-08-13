package com.example.airbnbbackend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


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
    private String idNumber;
    private String passport;

    @ManyToMany
    private List<Roles> roles;

}
