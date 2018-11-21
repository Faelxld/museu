package com.web.museu.dto;


import com.web.museu.domain.Entidade;
import com.web.museu.domain.TipoEntidade;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

public class TipoEntidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;

    public TipoEntidadeDTO() {
    }
    

    public TipoEntidadeDTO(TipoEntidade obj) {
        id = obj.getIdTipoEntidade();
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


    
    
    
}
