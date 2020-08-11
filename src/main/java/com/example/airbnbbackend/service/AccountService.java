package com.example.airbnbbackend.service;

import com.example.airbnbbackend.models.Accounts;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    void save(Accounts accounts);
    Iterable<Accounts> findAll();

    Accounts findAccountByUsername(String username);

}
