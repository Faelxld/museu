package com.web.museu.services;


import com.web.museu.domain.Regiao;
import com.web.museu.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegiaoService {

@Autowired
public RegiaoRepository repository;


public Regiao findOne(Integer id ){

    return repository.findOne(id);

}

}
