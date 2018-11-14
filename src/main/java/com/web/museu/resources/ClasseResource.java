package com.web.museu.resources;



import com.web.museu.domain.Classe;
import com.web.museu.services.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/classes")
public class ClasseResource {

    @Autowired
    private ClasseService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Classe listar(@PathVariable Integer id){

        Classe obj = service.findOne(id);

        return obj;
    }

}
