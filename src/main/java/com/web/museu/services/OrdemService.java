package com.web.museu.services;


import com.web.museu.domain.Ordem;
import com.web.museu.repositories.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemService {

@Autowired
public OrdemRepository repository;


public Ordem findOne(Integer id ){

    return repository.findOne(id);

}

}
