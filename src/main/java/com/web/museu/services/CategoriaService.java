package com.web.museu.services;

import com.web.museu.domain.Categoria;
import com.web.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

@Autowired
public CategoriaRepository repository;


public Categoria findOne(Integer id ){

    return repository.findOne(id);

}

}
