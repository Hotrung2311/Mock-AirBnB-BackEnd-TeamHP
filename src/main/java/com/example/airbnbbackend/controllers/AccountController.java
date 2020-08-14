package com.example.airbnbbackend.controllers;

import com.example.airbnbbackend.jwt.JwtResponse;
import com.example.airbnbbackend.jwt.JwtService;
import com.example.airbnbbackend.models.Accounts;
import com.example.airbnbbackend.models.Roles;
import com.example.airbnbbackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private PasswordEncoder passwordEncoder;
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
        Optional<Accounts> accounts1 = accountService.findAccountByUsername(accounts.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt ,accounts1.get().getId() , userDetails.getUsername(),userDetails.getAuthorities()));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Accounts accounts){
        String pass = accounts.getPassword();
        Optional<Accounts> accounts1 = accountService.findAccountByUsername(accounts.getUsername());
        if (accounts1.isEmpty()){
            List<Roles> roles = new ArrayList<Roles>();
            roles.add(new Roles((long) 1,"user"));
            roles.add(new Roles((long) 2,"customer"));
            roles.add(new Roles((long) 3,"PO"));
            accounts.setRoles(roles);
            accounts.setPassword(passwordEncoder.encode(accounts.getPassword()));
            accountService.save(accounts);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(accounts.getUsername(),pass));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(jwt ,accounts.getId() , userDetails.getUsername(),userDetails.getAuthorities()));
        }else {
            return (ResponseEntity<?>) ResponseEntity.unprocessableEntity();
        }

    }
}
