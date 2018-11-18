package com.web.museu.services;

import com.web.museu.domain.Local;
import com.web.museu.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocalService {

@Autowired
public LocalRepository repository;


public Local findOne(Integer id ){

    return repository.findOne(id);

}

public List<Local> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Local salvar(Local local){
    return repository.save(local);
}

public Local atualizar(Local local){
    return repository.saveAndFlush(local);
}

}
