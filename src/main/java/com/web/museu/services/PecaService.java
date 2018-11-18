package com.web.museu.services;

import com.web.museu.domain.Peca;
import com.web.museu.repositories.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PecaService {

@Autowired
public PecaRepository repository;


public Peca findOne(Integer id ){

    return repository.findOne(id);

}

public List<Peca> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Peca salvar(Peca peca){
    return repository.save(peca);
}

public Peca atualizar(Peca peca){
    return repository.saveAndFlush(peca);
}

}
