package com.web.museu.services;

import com.web.museu.domain.Classe;
import com.web.museu.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClasseService {

@Autowired
public ClasseRepository repository;


public Classe findOne(Integer id ){

    return repository.findOne(id);

}

public List<Classe> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Classe salvar(Classe classe){
    return repository.save(classe);
}

public Classe atualizar(Classe classe){
    return repository.saveAndFlush(classe);
}

}
