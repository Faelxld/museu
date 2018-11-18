package com.web.museu.services;

import com.web.museu.domain.Evento;
import com.web.museu.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventoService {

@Autowired
public EventoRepository repository;


public Evento findOne(Integer id ){

    return repository.findOne(id);

}

public List<Evento> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Evento salvar(Evento evento){
    return repository.save(evento);
}

public Evento atualizar(Evento evento){
    return repository.saveAndFlush(evento);
}

}
