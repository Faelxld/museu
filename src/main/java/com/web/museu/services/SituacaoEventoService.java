package com.web.museu.services;

import com.web.museu.domain.SituacaoEvento;
import com.web.museu.dto.SituacaoEventoDTO;
import com.web.museu.repositories.SituacaoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class SituacaoEventoService {

@Autowired
public SituacaoEventoRepository repository;


public SituacaoEvento findOne(Integer id ){

    return repository.findOne(id);

}

public List<SituacaoEvento> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public SituacaoEvento salvar(SituacaoEvento situacaoevento){
    return repository.save(situacaoevento);
}

public SituacaoEvento atualizar(SituacaoEvento situacaoevento){
   return repository.saveAndFlush(situacaoevento);
}


public Page<SituacaoEvento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public SituacaoEvento fromDTO(SituacaoEventoDTO objDto) {
        return new SituacaoEvento(objDto.getId(), objDto.getDescricao(),objDto.getEventos());
    }

}
