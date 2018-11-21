package com.web.museu.dto;


import com.web.museu.domain.Ordem;
import com.web.museu.domain.Peca;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

public class OrdemDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;
    private List<Peca> pecas;

    public OrdemDTO() {
    }

    public OrdemDTO(Integer id, String descricao, List<Peca> pecas) {
        this.id = id;
        this.descricao = descricao;
        this.pecas = pecas;
    }

    public OrdemDTO(Ordem obj) {
        id = obj.getIdOrdem();
        descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {this.descricao = descricao; }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }
    
    
}
