package com.web.museu.resources;

import com.web.museu.domain.Familia;
import com.web.museu.services.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/familias")
public class FamiliaResource {

    @Autowired
    private FamiliaService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Familia findOne(@PathVariable Integer id){

        Familia obj = service.findOne(id);

        return obj;
    }

}
