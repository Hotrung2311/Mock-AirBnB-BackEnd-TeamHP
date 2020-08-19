package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.Vote;
import com.example.airbnbbackend.repositories.VoteRepository;
import com.example.airbnbbackend.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    @Override
    public Optional<Vote> findByAccount_idAndHouse_Id(Long account_id, Long house_id) {
        return voteRepository.findByAccount_IdAndHouse_Id(account_id,house_id);
    }


    @Override
    public List<Vote> findByHouse_id(Long id) {
        return voteRepository.findByHouse_Id(id);
    }
}
