package com.web.museu.services;

import com.web.museu.domain.Evento;
import com.web.museu.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoService {

@Autowired
public EventoRepository repository;


public Evento findOne(Integer id ){

    return repository.findOne(id);

}

}
