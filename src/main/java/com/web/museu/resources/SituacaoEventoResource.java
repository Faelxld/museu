package com.web.museu.resources;

import com.web.museu.domain.SituacaoEvento;
import com.web.museu.services.SituacaoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/situacao_evento")
public class SituacaoEventoResource {

    @Autowired
    private SituacaoEventoService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public SituacaoEvento findOne(@PathVariable Integer id){

        SituacaoEvento obj = service.findOne(id);

        return obj;
    }

}
