package com.web.museu.services;

import com.web.museu.domain.Familia;
import com.web.museu.repositories.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamiliaService {

@Autowired
public FamiliaRepository repository;


public Familia findOne(Integer id ){

    return repository.findOne(id);

}

}
