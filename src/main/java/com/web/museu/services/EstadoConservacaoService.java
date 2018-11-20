package com.web.museu.services;

import com.web.museu.domain.Classe;
import com.web.museu.domain.EstadoConservacao;
import com.web.museu.dto.EstadoConservacaoDTO;
import com.web.museu.repositories.EstadoConservacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class EstadoConservacaoService {

@Autowired
public EstadoConservacaoRepository repository;


public EstadoConservacao findOne(Integer id ){

    return repository.findOne(id);

}

public List<EstadoConservacao> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public EstadoConservacao salvar(EstadoConservacao estadoconservacao){
    return repository.save(estadoconservacao);
}

public EstadoConservacao atualizar(EstadoConservacao estadoconservacao){
    return repository.saveAndFlush(estadoconservacao);
}
public Page<EstadoConservacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public EstadoConservacao fromDTO(EstadoConservacaoDTO objDto) {
        return new EstadoConservacao(objDto.getId(), objDto.getDescricao());
    }

}
