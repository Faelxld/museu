package com.web.museu.resources;


import com.web.museu.domain.Ordem;
import com.web.museu.domain.Ordem;
import com.web.museu.dto.OrdemDTO;
import com.web.museu.services.OrdemService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/ordem")
public class OrdemResource {

    @Autowired
    private OrdemService service;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Ordem> find(@PathVariable Integer id) {
        Ordem obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody OrdemDTO objDto) {
        Ordem obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdOrdem()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody OrdemDTO objDto, @PathVariable Integer id) {
        Ordem obj = service.fromDTO(objDto);
        obj.setIdOrdem(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<OrdemDTO>> findAll() {
        List<Ordem> list = service.listar();
        List<OrdemDTO> listDto = list.stream().map(obj -> new OrdemDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<OrdemDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {


        Page<Ordem> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<OrdemDTO> listDto = list.map(obj -> new OrdemDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }

}
