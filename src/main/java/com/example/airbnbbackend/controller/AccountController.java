package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.jwt.JwtResponse;
import com.example.airbnbbackend.jwt.JwtService;
import com.example.airbnbbackend.model.Account;
import com.example.airbnbbackend.model.Role;
import com.example.airbnbbackend.service.AccountService;
import com.example.airbnbbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    @Autowired
    private RoleService roleService;

    @Autowired
    public JavaMailSender emailSender;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(),account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentUser = accountService.findAccountByUserName(account.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt ,currentUser.getId() , userDetails.getUsername(),userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Account account){
        String pass = account.getPassword();
        Account accounts1 = accountService.findAccountByUserName(account.getUsername());
        if (accounts1 == null){
            Role role = new Role();
            role.setId((long) 2);
            role.setName("user");
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            account.setRoles(roles);
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            accountService.save(account);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(account.getEmail());
            message.setSubject("Test Simple Email");
            message.setText("Username: "+account.getUsername()+" password: "+account.getPassword());
            this.emailSender.send(message);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUsername(),pass));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(jwt ,account.getId() , userDetails.getUsername(),userDetails.getAuthorities()));
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id){
        Optional<Account> account = accountService.findById(id);
        if (account.isPresent()){
            return ResponseEntity.ok(account.get());
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/profile/edit")
    public ResponseEntity<?> editProfile(@RequestBody Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
