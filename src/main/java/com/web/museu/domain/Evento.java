package com.web.museu.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
public class Evento implements Serializable {


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
    @Basic
    @Temporal(TemporalType.DATE)
   private Date data;
    @Basic
    @Temporal(TemporalType.TIME)
   private Date inicioEvento;
    @Basic
    @Temporal(TemporalType.TIME)
   private Date fimEvento;
   @OneToOne
   @JoinTable(name="entidade_evento",
            joinColumns={@JoinColumn(name="evento_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="entidade_id",
                    referencedColumnName="id")})
   private Entidade idSolicitante;
   @OneToOne
   @JoinTable(name="evento_local",
           joinColumns={@JoinColumn(name="evento_id",
                   referencedColumnName="id")},
           inverseJoinColumns={@JoinColumn(name="local_id",
                   referencedColumnName="id")})
   private Local idLocal;
   @ManyToMany
   private List<Peca> pecas;
    @OneToOne
    @JoinTable(name="evento_situacao",
            joinColumns={@JoinColumn(name="evento_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="situacao_id",
                    referencedColumnName="id")})
    private SituacaoEvento idSituacaoEvento;

    public Evento(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvento() {
        return id;
    }

    public void setIdEvento(int idEvento) {
        this.id = idEvento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public SituacaoEvento getIdSituacaoEvento() {
        return idSituacaoEvento;
    }

    public void setIdSituacaoEvento(SituacaoEvento idSituacaoEvento) {
        this.idSituacaoEvento = idSituacaoEvento;
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
}
