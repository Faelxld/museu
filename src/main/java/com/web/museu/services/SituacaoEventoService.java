package com.web.museu.services;


import com.web.museu.domain.SituacaoEvento;
import com.web.museu.repositories.SituacaoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SituacaoEventoService {

@Autowired
public SituacaoEventoRepository repository;


public SituacaoEvento findOne(Integer id ){

    return repository.findOne(id);

}

}
