package com.web.museu.resources;

import com.web.museu.domain.TipoEntidade;
import com.web.museu.services.TipoEntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/tipo_entidade")
public class TipoEntidadeResource {

    @Autowired
    private TipoEntidadeService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public TipoEntidade findOne(@PathVariable Integer id){

        TipoEntidade obj = service.findOne(id);

        return obj;
    }

}
