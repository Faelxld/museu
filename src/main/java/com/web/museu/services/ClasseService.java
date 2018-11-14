package com.web.museu.services;


import com.web.museu.domain.Classe;
import com.web.museu.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClasseService {

@Autowired
public ClasseRepository repository;


public Classe findOne(Integer id ){

    return repository.findOne(id);

}

}
