package com.example.airbnbbackend.service;

import com.example.airbnbbackend.models.Accounts;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface AccountService extends UserDetailsService {
    void save(Accounts accounts);
    Iterable<Accounts> findAll();

    Optional<Accounts> findAccountByUsername(String username);

}
