package com.web.museu.dto;


import com.web.museu.domain.Classe;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class ClasseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;

    public ClasseDTO() {
    }

    public ClasseDTO(Classe obj) {
        id = obj.getIdClasse();
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
