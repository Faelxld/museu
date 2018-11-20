package com.web.museu.services;

import com.web.museu.domain.Regiao;
import com.web.museu.dto.RegiaoDTO;
import com.web.museu.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class RegiaoService {

@Autowired
public RegiaoRepository repository;


public Regiao findOne(Integer id ){

    return repository.findOne(id);

}

public List<Regiao> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Regiao salvar(Regiao regiao){
    return repository.save(regiao);
}

public Regiao atualizar(Regiao regiao){
    return repository.saveAndFlush(regiao);
}

public Page<Regiao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Regiao fromDTO(RegiaoDTO objDto) {
        return new Regiao(objDto.getId(), objDto.getDescricao());
    }

}
