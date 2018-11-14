package com.web.museu.services;

import com.web.museu.domain.Entidade;
import com.web.museu.repositories.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntidadeService {

@Autowired
public EntidadeRepository repository;


public Entidade findOne(Integer id ){

    return repository.findOne(id);

}

}
