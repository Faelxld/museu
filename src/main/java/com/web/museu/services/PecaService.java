package com.web.museu.services;


import com.web.museu.domain.Peca;
import com.web.museu.repositories.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PecaService {

@Autowired
public PecaRepository repository;


public Peca findOne(Integer id ){

    return repository.findOne(id);

}

}
