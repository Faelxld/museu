package com.web.museu.resources;

import com.web.museu.domain.Local;
import com.web.museu.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/local")
public class LocalResource {

    @Autowired
    private LocalService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Local findOne(@PathVariable Integer id){

        Local obj = service.findOne(id);

        return obj;
    }

}
