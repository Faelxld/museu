package com.web.museu.dto;


import com.web.museu.domain.Peca;
import com.web.museu.domain.Regiao;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class RegiaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;
    private Collection<Peca> pecas;

    public RegiaoDTO() {
    }

    public RegiaoDTO(Regiao obj) {
        id = obj.getIdRegiao();
        descricao = obj.getDescricao();
        pecas = obj.getPecaCollection();
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



    
}
