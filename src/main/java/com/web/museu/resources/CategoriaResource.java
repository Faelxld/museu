package com.web.museu.resources;


import com.web.museu.domain.Categoria;
import com.web.museu.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;


    @RequestMapping(value ="/{id}", method= RequestMethod.GET)
    public Categoria findOne(@PathVariable Integer id){

        Categoria obj = service.findOne(id);

        return obj;
    }

}
