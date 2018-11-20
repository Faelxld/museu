package com.web.museu.services;

import com.web.museu.domain.Ordem;
import com.web.museu.dto.OrdemDTO;
import com.web.museu.repositories.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


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

public Page<Ordem> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Ordem fromDTO(OrdemDTO objDto) {
        return new Ordem(objDto.getId(), objDto.getDescricao());
    }

}
