package com.web.museu.dto;


import com.web.museu.domain.Evento;
import com.web.museu.domain.SituacaoEvento;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

public class SituacaoEventoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;
    private List<Evento> eventos;

    public SituacaoEventoDTO() {
    }

    public SituacaoEventoDTO(SituacaoEvento obj) {
        id = obj.getId();
        descricao = obj.getDescricao();
        eventos = obj.getEventos();
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

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
    
    
}
