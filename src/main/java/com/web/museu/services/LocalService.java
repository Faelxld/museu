package com.web.museu.services;

import com.web.museu.domain.Local;
import com.web.museu.dto.LocalDTO;
import com.web.museu.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


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

public Page<Local> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Local fromDTO(LocalDTO objDto) {
        return new Local(objDto.getId(), objDto.getDescricao());
    }

}
