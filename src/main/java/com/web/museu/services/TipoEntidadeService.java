package com.web.museu.services;


import com.web.museu.domain.TipoEntidade;
import com.web.museu.repositories.TipoEntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoEntidadeService {

@Autowired
public TipoEntidadeRepository repository;


public TipoEntidade findOne(Integer id ){

    return repository.findOne(id);

}

}
