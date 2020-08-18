package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.Role;
import com.example.airbnbbackend.repositories.RoleRepository;
import com.example.airbnbbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }
}
