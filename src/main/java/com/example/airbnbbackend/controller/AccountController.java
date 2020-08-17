package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.jwt.JwtResponse;
import com.example.airbnbbackend.jwt.JwtService;
import com.example.airbnbbackend.model.Account;
import com.example.airbnbbackend.model.Role;
import com.example.airbnbbackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    public JavaMailSender emailSender;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(),account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<Account> currentUser = accountService.findAccountByUserName(account.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt ,currentUser.get().getId() , userDetails.getUsername(),userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Account account){
        String pass = account.getPassword();
        Optional<Account> accounts1 = accountService.findAccountByUserName(account.getUsername());
        if (accounts1.isEmpty()){
            List<Role> roles = new ArrayList<>();
            roles.add(new Role( 1,"user"));
            roles.add(new Role( 2,"customer"));
            roles.add(new Role( 3,"PO"));
            account.setRoles(roles);
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            accountService.save(account);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUsername(),pass));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(jwt ,account.getId() , userDetails.getUsername(),userDetails.getAuthorities()));
        }else {
            return (ResponseEntity<?>) ResponseEntity.unprocessableEntity();
        }

    }
}
