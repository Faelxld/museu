package com.web.museu.resources;

import com.web.museu.domain.TipoEntidade;
import com.web.museu.dto.TipoEntidadeDTO;
import com.web.museu.services.TipoEntidadeService;
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
@RequestMapping(value="/tipo_entidade")
public class TipoEntidadeResource {

    @Autowired
    private TipoEntidadeService service;


     @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TipoEntidade> find(@PathVariable Integer id) {
        TipoEntidade obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody TipoEntidadeDTO objDto) {
        TipoEntidade obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdTipoEntidade()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody TipoEntidadeDTO objDto, @PathVariable Integer id) {
        TipoEntidade obj = service.fromDTO(objDto);
        obj.setIdTipoEntidade(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<TipoEntidadeDTO>> findAll() {
        List<TipoEntidade> list = service.listar();
        List<TipoEntidadeDTO> listDto = list.stream().map(obj -> new TipoEntidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<TipoEntidadeDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {


        Page<TipoEntidade> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<TipoEntidadeDTO> listDto = list.map(obj -> new TipoEntidadeDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }

}
