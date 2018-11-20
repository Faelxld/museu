package com.web.museu.resources;

import com.web.museu.domain.SituacaoEvento;
import com.web.museu.dto.SituacaoEventoDTO;
import com.web.museu.services.SituacaoEventoService;
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
@RequestMapping(value="/situacao_evento")
public class SituacaoEventoResource {

    @Autowired
    private SituacaoEventoService service;


       @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<SituacaoEvento> find(@PathVariable Integer id) {
        SituacaoEvento obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody SituacaoEventoDTO objDto) {
        SituacaoEvento obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody SituacaoEventoDTO objDto, @PathVariable Integer id) {
        SituacaoEvento obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<SituacaoEventoDTO>> findAll() {
        List<SituacaoEvento> list = service.listar();
        List<SituacaoEventoDTO> listDto = list.stream().map(obj -> new SituacaoEventoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<SituacaoEventoDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {


        Page<SituacaoEvento> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<SituacaoEventoDTO> listDto = list.map(obj -> new SituacaoEventoDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }

}
