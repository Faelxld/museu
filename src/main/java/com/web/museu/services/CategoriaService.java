package com.web.museu.services;

import com.web.museu.domain.Categoria;
import com.web.museu.dto.CategoriaDTO;
import com.web.museu.repositories.CategoriaRepository;
import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

public Categoria salvar(Categoria categoria){
    return repository.save(categoria);
}

public Categoria atualizar(Categoria categoria){
    return repository.saveAndFlush(categoria);
}

public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Categoria fromDTO(CategoriaDTO objDto) {
        return new Categoria(objDto.getId(), objDto.getDescricao());
    }


}
