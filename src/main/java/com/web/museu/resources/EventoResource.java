package com.web.museu.resources;

import com.web.museu.domain.Evento;
import com.web.museu.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {

    @Autowired
    private EventoService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Evento findOne(@PathVariable Integer id){

        Evento obj = service.findOne(id);

        return obj;
    }

}
