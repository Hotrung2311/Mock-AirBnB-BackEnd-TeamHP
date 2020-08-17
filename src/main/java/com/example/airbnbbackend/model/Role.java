package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;

    public Role(long id, String user) {
        this.id=id;
        this.roleName=user;
    }

    public Role(String host) {
        this.roleName=host;
    }
}
