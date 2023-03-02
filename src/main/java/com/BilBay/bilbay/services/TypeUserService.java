package com.BilBay.bilbay.services;

import com.BilBay.bilbay.repositories.TypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeUserService {

    private final TypeUserRepository typeUserRepository;

    @Autowired
    public TypeUserService(TypeUserRepository typeUserRepository) {
        this.typeUserRepository = typeUserRepository;
    }
}
