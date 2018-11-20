package com.web.museu.services;

import com.web.museu.domain.TipoEntidade;
import com.web.museu.dto.TipoEntidadeDTO;
import com.web.museu.repositories.TipoEntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class TipoEntidadeService {

@Autowired
public TipoEntidadeRepository repository;


public TipoEntidade findOne(Integer id ){

    return repository.findOne(id);

}

public List<TipoEntidade> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public TipoEntidade salvar(TipoEntidade tipoentidade){
   return repository.save(tipoentidade);
}

public TipoEntidade atualizar(TipoEntidade tipoentidade){
    return repository.saveAndFlush(tipoentidade);
}

public Page<TipoEntidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public TipoEntidade fromDTO(TipoEntidadeDTO objDto) {
        return new TipoEntidade(objDto.getId(), objDto.getDescricao());
    }

}
