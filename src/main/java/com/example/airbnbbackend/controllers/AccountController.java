package com.example.airbnbbackend.controllers;

import com.example.airbnbbackend.jwt.JwtResponse;
import com.example.airbnbbackend.jwt.JwtService;
import com.example.airbnbbackend.models.Accounts;
import com.example.airbnbbackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("http://localhost:4200")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Accounts accounts){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accounts.getUsername(),accounts.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Accounts accounts1 = accountService.findAccountByUsername(accounts.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt ,accounts1.getId() , userDetails.getUsername()));
    }
}
