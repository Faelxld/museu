package com.web.museu.services;

import com.web.museu.domain.Entidade;
import com.web.museu.dto.EntidadeDTO;
import com.web.museu.repositories.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class EntidadeService {

@Autowired
public EntidadeRepository repository;


public Entidade findOne(Integer id ){

    return repository.findOne(id);

}

public List<Entidade> listar(){
    return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Entidade salvar(Entidade entidade){
    return repository.save(entidade);
}

public Entidade atualizar(Entidade entidade){
   return repository.saveAndFlush(entidade);
}

public Page<Entidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Entidade fromDTO(EntidadeDTO objDto) {
        return new Entidade(objDto.getId(), objDto.getNome(),objDto.getTipoentidade());
    }

}
