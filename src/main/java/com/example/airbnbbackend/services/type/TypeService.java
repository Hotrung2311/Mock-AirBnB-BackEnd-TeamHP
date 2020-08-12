package com.example.airbnbbackend.services.type;

import com.example.airbnbbackend.models.Types;
import com.example.airbnbbackend.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Types> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Types> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public Types findByName(String username) {
        return typeRepository.findByName(username);
    }

    @Override
    public Types save(Types types) {
        return typeRepository.save(types);
    }

    @Override
    public void remove(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public void remove(Types types) {
        typeRepository.delete(types);
    }
}
