package com.web.museu.services;

import com.web.museu.domain.Peca;
import com.web.museu.dto.PecaDTO;
import com.web.museu.repositories.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class PecaService {

@Autowired
public PecaRepository repository;


public Peca findOne(Integer id ){

    return repository.findOne(id);

}

public List<Peca> listar(){

        return repository.findAll();

}

public void deletar(Integer id){
    repository.delete(id);
}

public Peca salvar(Peca peca){
    return repository.save(peca);
}

public Peca atualizar(Peca peca){
    return repository.saveAndFlush(peca);
}
public Page<Peca> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
public Peca fromDTO(PecaDTO objDto) {
        return new Peca(objDto.getId(),objDto.getDataCadastro(),objDto.getData(),objDto.getObservacao(),objDto.getCodigoInterno(),objDto.getDescricao(),objDto.getDoador(),objDto.getIdRegiao(),objDto.getOrdem(),objDto.getFamilia(),objDto.getClasse(),objDto.getIdCategoria(),objDto.getIdEstadoConservacao());
    }



}
