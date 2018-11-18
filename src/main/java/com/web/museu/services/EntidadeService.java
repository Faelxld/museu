package com.web.museu.services;

import com.web.museu.domain.Entidade;
import com.web.museu.repositories.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntidadeService {

@Autowired
public EntidadeRepository repository;


public Entidade findOne(Integer id ){

    return repository.findOne(id);

}

public List<Entidade> listar(){
    return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Entidade salvar(Entidade entidade){
    return repository.save(entidade);
}

public Entidade atualizar(Entidade entidade){
   return repository.saveAndFlush(entidade);
}

}
