package com.web.museu.resources;


import com.web.museu.domain.Entidade;
import com.web.museu.services.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/entidades")
public class EntidadeResource {

    @Autowired
    private EntidadeService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Entidade findOne(@PathVariable Integer id){

        Entidade obj = service.findOne(id);

        return obj;
    }

}
