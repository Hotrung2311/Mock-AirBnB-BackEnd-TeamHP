package com.example.airbnbbackend.model;

import com.example.airbnbbackend.model.House;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room_type")
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roomTypes")
    @JsonBackReference
    private List<House> houses;

}
