package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Role;
import org.springframework.stereotype.Service;

public interface RoleService {
    Role findRoleByName(String name);
    void save(Role role);
    Iterable<Role> findAll();
}
