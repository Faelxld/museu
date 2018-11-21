package com.web.museu.resources;


import com.web.museu.domain.Peca;
import com.web.museu.dto.PecaDTO;
import com.web.museu.services.PecaService;
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
@RequestMapping(value="/pecas")
public class PecaResource {

    @Autowired
    private PecaService service;


   @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Peca> find(@PathVariable Integer id) {
        Peca obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PecaDTO objDto) {
        Peca obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdPeca()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody PecaDTO objDto, @PathVariable Integer id) {
        Peca obj = service.fromDTO(objDto);
        obj.setIdPeca(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<PecaDTO>> findAll() {
        List<Peca> list = service.listar();
        List<PecaDTO> listDto = list.stream().map(obj -> new PecaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<PecaDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {


        Page<Peca> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<PecaDTO> listDto = list.map(obj -> new PecaDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }

}
