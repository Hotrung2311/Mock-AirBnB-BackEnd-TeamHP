package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface AccountService extends UserDetailsService {
    void save(Account account);

    Iterable<Account> findAll();

    Optional<Account> findAccountByUserName(String username);
}
