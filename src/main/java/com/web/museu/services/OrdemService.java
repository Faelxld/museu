package com.web.museu.services;

import com.web.museu.domain.Ordem;
import com.web.museu.repositories.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdemService {

@Autowired
public OrdemRepository repository;


public Ordem findOne(Integer id ){

    return repository.findOne(id);

}

public List<Ordem> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Ordem salvar(Ordem ordem){
    return repository.save(ordem);
}

public Ordem atualizar(Ordem ordem){
   return  repository.saveAndFlush(ordem);
}

}
