package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Role;

public interface RoleService {
    Role findRoleByName(String name);
    void save(Role role);
    Iterable<Role> findAll();
}
