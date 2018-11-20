/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.museu.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento")
    , @NamedQuery(name = "Evento.findByData", query = "SELECT e FROM Evento e WHERE e.data = :data")
    , @NamedQuery(name = "Evento.findByInicioEvento", query = "SELECT e FROM Evento e WHERE e.inicioEvento = :inicioEvento")
    , @NamedQuery(name = "Evento.findByFimEvento", query = "SELECT e FROM Evento e WHERE e.fimEvento = :fimEvento")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idEvento")
    private Integer idEvento;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "inicioEvento")
    @Temporal(TemporalType.TIME)
    private Date inicioEvento;
    @Column(name = "fimEvento")
    @Temporal(TemporalType.TIME)
    private Date fimEvento;
    @JoinColumn(name = "idSituacaoEvento", referencedColumnName = "idSituacaoEvento")
    @ManyToOne
    private DefSituacaoEvento idSituacaoEvento;
    @JoinColumn(name = "idLocal", referencedColumnName = "idLocal")
    @ManyToOne
    private Local idLocal;
    @JoinColumn(name = "idSolicitante", referencedColumnName = "idEntidade")
    @ManyToOne
    private Entidade idSolicitante;
    @OneToMany
    private Collection<Peca> pecaCollection;

    public Evento() {
    }

    public Evento(Integer idEvento)
    {
        this.idEvento = idEvento;
    }
    public Evento(int id, Date data, Date inicioEvento, Date fimEvento, Entidade idSolicitante, Local idLocal, DefSituacaoEvento idSituacaoEvento) {
        this.idEvento = id;
        this.data = data;
        this.inicioEvento = inicioEvento;
        this.fimEvento = fimEvento;
        this.idSolicitante = idSolicitante;
        this.idLocal = idLocal;
        this.idSituacaoEvento = idSituacaoEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
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

    public DefSituacaoEvento getIdSituacaoEvento() {
        return idSituacaoEvento;
    }

    public void setIdSituacaoEvento(DefSituacaoEvento idSituacaoEvento) {
        this.idSituacaoEvento = idSituacaoEvento;
    }

    public Local getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
    }

    public Entidade getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Entidade idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Evento[ idEvento=" + idEvento + " ]";
    }

    public Collection<Peca> getPecaCollection() {
        return pecaCollection;
    }

    public void setPecaCollection(Collection<Peca> pecaCollection) {
        this.pecaCollection = pecaCollection;
    }
}
