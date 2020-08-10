package com.example.airbnbbackend.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long Room;
    private Integer bathRoom;
    private Boolean Pool;
    private Boolean garden;
    private Boolean Balcony;

    @ManyToOne
    private Types types;

}
