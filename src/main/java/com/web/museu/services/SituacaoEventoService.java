package com.web.museu.services;

import com.web.museu.domain.SituacaoEvento;
import com.web.museu.repositories.SituacaoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SituacaoEventoService {

@Autowired
public SituacaoEventoRepository repository;


public SituacaoEvento findOne(Integer id ){

    return repository.findOne(id);

}

public List<SituacaoEvento> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public SituacaoEvento salvar(SituacaoEvento situacaoevento){
    return repository.save(situacaoevento);
}

public SituacaoEvento atualizar(SituacaoEvento situacaoevento){
   return repository.saveAndFlush(situacaoevento);
}

}
