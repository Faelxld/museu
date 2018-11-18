package com.web.museu.services;

import com.web.museu.domain.Regiao;
import com.web.museu.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegiaoService {

@Autowired
public RegiaoRepository repository;


public Regiao findOne(Integer id ){

    return repository.findOne(id);

}

public List<Regiao> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Regiao salvar(Regiao regiao){
    return repository.save(regiao);
}

public Regiao atualizar(Regiao regiao){
    return repository.saveAndFlush(regiao);
}

}
