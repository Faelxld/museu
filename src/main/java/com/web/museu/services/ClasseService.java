package com.web.museu.services;

import com.web.museu.domain.Classe;
import com.web.museu.dto.ClasseDTO;
import com.web.museu.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


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

public Page<Classe> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Classe fromDTO(ClasseDTO objDto) {
        return new Classe(objDto.getId(), objDto.getDescricao());
    }


}
