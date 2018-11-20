package com.web.museu.services;

import com.web.museu.domain.Familia;
import com.web.museu.dto.FamiliaDTO;
import com.web.museu.repositories.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


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
public Page<Familia> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Familia fromDTO(FamiliaDTO objDto) {
        return new Familia(objDto.getId(), objDto.getDescricao());
    }

}
