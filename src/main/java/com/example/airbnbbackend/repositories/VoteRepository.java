package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    Optional<Vote> findByAccount_Id(Long id);
    List<Vote> findByHouse_Id(Long id);
}
