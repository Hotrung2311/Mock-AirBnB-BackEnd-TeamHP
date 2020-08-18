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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_role",joinColumns = {@JoinColumn(name ="account_id" )},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

}
