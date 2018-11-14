package com.web.museu.services;

import com.web.museu.domain.EstadoConservacao;
import com.web.museu.repositories.EstadoConservacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoConservacaoService {

@Autowired
public EstadoConservacaoRepository repository;


public EstadoConservacao findOne(Integer id ){

    return repository.findOne(id);

}

}
