package com.web.museu.resources;


import com.web.museu.domain.Ordem;
import com.web.museu.services.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ordem")
public class OrdemResource {

    @Autowired
    private OrdemService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Ordem findOne(@PathVariable Integer id){

        Ordem obj = service.findOne(id);

        return obj;
    }

}
