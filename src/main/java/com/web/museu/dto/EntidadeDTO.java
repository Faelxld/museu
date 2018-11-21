package com.web.museu.dto;


import com.web.museu.domain.Entidade;
import com.web.museu.domain.Evento;
import com.web.museu.domain.Peca;
import com.web.museu.domain.TipoEntidade;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class EntidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String nome;
    private TipoEntidade  tipoEntidade;
    private Collection<Peca> Peca;
    private Collection<Evento> Eventos;


    

    public EntidadeDTO() {
    }

    public EntidadeDTO(Entidade obj) {
        this.id = obj.getIdEntidade();
        this.nome = obj.getNome();
        this.Peca = obj.getPecaCollection();
        this.Eventos = obj.getEventoCollection();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoEntidade getTipoentidade() {
        return tipoEntidade;
    }

    public void setTipoentidade(TipoEntidade tipoentidade) {
        this.tipoEntidade = tipoentidade;
    }




}
