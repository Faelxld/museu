package com.web.museu.services;

import com.web.museu.domain.Categoria;
import com.web.museu.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriaService {

@Autowired
public CategoriaRepository repository;


public Categoria findOne(Integer id ){ return repository.findOne(id); }

public List<Categoria> listar(){ return repository.findAll(); }

public void deletar(Integer id){
    repository.delete(id);
}

public void salvar(Categoria categoria){
    repository.save(categoria);
}

public void atualizar(Categoria categoria){
    repository.saveAndFlush(categoria);
}

}
