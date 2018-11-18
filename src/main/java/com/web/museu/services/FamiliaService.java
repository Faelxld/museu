package com.web.museu.services;

import com.web.museu.domain.Familia;
import com.web.museu.repositories.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FamiliaService {

@Autowired
public FamiliaRepository repository;


public Familia findOne(Integer id ){

    return repository.findOne(id);

}

public List<Familia> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Familia salvar(Familia familia){
    return repository.save(familia);
}

public Familia atualizar(Familia familia){
    return repository.saveAndFlush(familia);
}

}
