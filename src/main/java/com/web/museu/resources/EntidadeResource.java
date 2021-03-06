package com.web.museu.resources;


import com.web.museu.domain.Entidade;
import com.web.museu.dto.EntidadeDTO;
import com.web.museu.services.EntidadeService;
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
@RequestMapping(value="/entidades")
public class EntidadeResource {

    @Autowired
    private EntidadeService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Entidade> find(@PathVariable Integer id) {
        Entidade obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody EntidadeDTO objDto) {
        Entidade obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdEntidade()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody EntidadeDTO objDto, @PathVariable Integer id) {
        Entidade obj = service.fromDTO(objDto);
        obj.setIdEntidade(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<EntidadeDTO>> findAll() {
        List<Entidade> list = service.listar();
        List<EntidadeDTO> listDto = list.stream().map(obj -> new EntidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<EntidadeDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {


        Page<Entidade> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<EntidadeDTO> listDto = list.map(obj -> new EntidadeDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }

}
