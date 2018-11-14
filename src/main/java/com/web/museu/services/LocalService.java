package com.web.museu.services;

import com.web.museu.domain.Local;
import com.web.museu.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocalService {

@Autowired
public LocalRepository repository;


public Local findOne(Integer id ){

    return repository.findOne(id);

}

}
