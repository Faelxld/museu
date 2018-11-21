package com.web.museu.dto;


import com.web.museu.domain.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class EventoDTO implements Serializable {

   private static final long serialVersionUID = 1L;
   private Integer id;
   private Date data;
    @NotEmpty(message="Preenchimento obrigatório")
   private Date inicioEvento;
    @NotEmpty(message="Preenchimento obrigatório")
   private Date fimEvento;
    @NotEmpty(message="Preenchimento obrigatório")
   private Entidade idSolicitante;
    @NotEmpty(message="Preenchimento obrigatório")
   private Local idLocal;
   
   private Collection<Peca> pecas;
  
    private DefSituacaoEvento idSituacaoEvento;

    public EventoDTO() {
    }

    public EventoDTO(Evento obj) {
        this.id = obj.getIdEvento();
        this.data = obj.getData();
        this.inicioEvento = obj.getInicioEvento();
        this.fimEvento = obj.getFimEvento();
        this.idSolicitante = obj.getIdSolicitante();
        this.idLocal = obj.getIdLocal();
        this.pecas = obj.getPecaCollection();
        this.idSituacaoEvento = obj.getIdSituacaoEvento();
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getInicioEvento() {
        return inicioEvento;
    }

    public void setInicioEvento(Date inicioEvento) {
        this.inicioEvento = inicioEvento;
    }

    public Date getFimEvento() {
        return fimEvento;
    }

    public void setFimEvento(Date fimEvento) {
        this.fimEvento = fimEvento;
    }

    public Entidade getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Entidade idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public Local getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
    }

    public Collection<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public DefSituacaoEvento getIdSituacaoEvento() {
        return idSituacaoEvento;
    }

    public void setIdSituacaoEvento(DefSituacaoEvento idSituacaoEvento) {
        this.idSituacaoEvento = idSituacaoEvento;
    }

    
    
}
