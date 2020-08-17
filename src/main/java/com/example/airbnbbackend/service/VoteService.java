package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Vote;

import java.util.List;
import java.util.Optional;

public interface VoteService {
    void save (Vote vote);

    List<Vote> findAll();

    Optional<Vote> findByAccount_id(Long id);
    List<Vote> findByHouse_id(Long id);
}
