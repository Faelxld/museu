package com.web.museu.services;

import com.web.museu.domain.EstadoConservacao;
import com.web.museu.repositories.EstadoConservacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstadoConservacaoService {

@Autowired
public EstadoConservacaoRepository repository;


public EstadoConservacao findOne(Integer id ){

    return repository.findOne(id);

}

public List<EstadoConservacao> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public EstadoConservacao salvar(EstadoConservacao estadoconservacao){
    return repository.save(estadoconservacao);
}

public EstadoConservacao atualizar(EstadoConservacao estadoconservacao){
    return repository.saveAndFlush(estadoconservacao);
}

}
