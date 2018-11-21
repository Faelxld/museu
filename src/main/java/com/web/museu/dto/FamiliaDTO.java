package com.web.museu.dto;


import com.web.museu.domain.Familia;
import com.web.museu.domain.Peca;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class FamiliaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;
    private Collection<Peca> pecas;

    public FamiliaDTO() {
    }

    public FamiliaDTO(Familia obj) {
        id = obj.getIdFamilia();
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



    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }
    
    
}
