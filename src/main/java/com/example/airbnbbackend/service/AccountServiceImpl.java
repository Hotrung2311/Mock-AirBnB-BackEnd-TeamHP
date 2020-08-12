package com.example.airbnbbackend.service;

import com.example.airbnbbackend.models.Accounts;
import com.example.airbnbbackend.principle.UserPrinciple;
import com.example.airbnbbackend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.Optional;

public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void save(Accounts accounts) {
        accountRepository.save(accounts);
    }

    @Override
    public Iterable<Accounts> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Accounts> findAccountByUsername(String username) {
        return accountRepository.findAccountsByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Accounts> accounts = accountRepository.findAccountsByUsername(username);
        if (!accounts.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(accounts.get());
    }
}
