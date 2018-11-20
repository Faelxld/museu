package com.web.museu.resources;



import com.web.museu.domain.EstadoConservacao;
import com.web.museu.dto.EstadoConservacaoDTO;
import com.web.museu.services.EstadoConservacaoService;
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
@RequestMapping(value="/estado_conservacao")
public class EstadoConservacaoResource {

    @Autowired
    private EstadoConservacaoService service;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<EstadoConservacao> find(@PathVariable Integer id) {
        EstadoConservacao obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody EstadoConservacaoDTO objDto) {
        EstadoConservacao obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdEstadoConservacao()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody EstadoConservacaoDTO objDto, @PathVariable Integer id) {
        EstadoConservacao obj = service.fromDTO(objDto);
        obj.setIdEstadoConservacao(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<EstadoConservacaoDTO>> findAll() {
        List<EstadoConservacao> list = service.listar();
        List<EstadoConservacaoDTO> listDto = list.stream().map(obj -> new EstadoConservacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<EstadoConservacaoDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {


        Page<EstadoConservacao> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<EstadoConservacaoDTO> listDto = list.map(obj -> new EstadoConservacaoDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }

}
