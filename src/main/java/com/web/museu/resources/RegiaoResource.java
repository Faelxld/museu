package com.web.museu.resources;


import com.web.museu.domain.Regiao;
import com.web.museu.services.RegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/regiao")
public class RegiaoResource {

    @Autowired
    private RegiaoService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Regiao findOne(@PathVariable Integer id){

        Regiao obj = service.findOne(id);

        return obj;
    }

}
