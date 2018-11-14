package com.web.museu.resources;


import com.web.museu.domain.Peca;
import com.web.museu.services.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/peca")
public class PecaResource {

    @Autowired
    private PecaService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Peca findOne(@PathVariable Integer id){

        Peca obj = service.findOne(id);

        return obj;
    }

}
