package com.web.museu.services;

import com.web.museu.domain.Evento;
import com.web.museu.dto.EventoDTO;
import com.web.museu.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


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

public Page<Evento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Evento fromDTO(EventoDTO objDto) {
        return new Evento(objDto.getId(), objDto.getData(),objDto.getInicioEvento(),objDto.getFimEvento(),objDto.getIdSolicitante(),objDto.getIdLocal(),objDto.getIdSituacaoEvento());
    }

}
