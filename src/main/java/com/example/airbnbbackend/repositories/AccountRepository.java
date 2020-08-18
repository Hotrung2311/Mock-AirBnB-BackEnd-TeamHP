package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.Account;
import com.example.airbnbbackend.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountsByUsername(String username);

    Optional<Account> findById(Long id);

    // bang add

    Optional<Account> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
//    Account findAllByHouse(House house);

}
