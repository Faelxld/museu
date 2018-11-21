package com.web.museu.dto;


import com.web.museu.domain.Evento;
import com.web.museu.domain.Local;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

public class LocalDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;
    private List<Evento> eventos;

    public LocalDTO() {
    }

    public LocalDTO(Integer id, String descricao, List<Evento> eventos) {
        this.id = id;
        this.descricao = descricao;
        this.eventos = eventos;
    }
    
    

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public LocalDTO(Local obj) {
        id = obj.getIdLocal();
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
