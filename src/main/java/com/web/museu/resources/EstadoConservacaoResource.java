package com.web.museu.resources;


import com.web.museu.domain.EstadoConservacao;
import com.web.museu.services.EstadoConservacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/estado_conservacao")
public class EstadoConservacaoResource {

    @Autowired
    private EstadoConservacaoService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public EstadoConservacao findOne(@PathVariable Integer id){

        EstadoConservacao obj = service.findOne(id);

        return obj;
    }

}
