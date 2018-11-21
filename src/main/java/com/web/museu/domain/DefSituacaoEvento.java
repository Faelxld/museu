package com.web.museu.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "DefSituacaoEvento")
@XmlRootElement
public class DefSituacaoEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idSituacaoEvento")
    private Integer idSituacaoEvento;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idSituacaoEvento")
    private Collection<Evento> eventoCollection;

    public DefSituacaoEvento() {
    }

    public DefSituacaoEvento(Integer idSituacaoEvento) {
        this.idSituacaoEvento = idSituacaoEvento;
    }

    public Integer getIdSituacaoEvento() {
        return idSituacaoEvento;
    }

    public void setIdSituacaoEvento(Integer idSituacaoEvento) {
        this.idSituacaoEvento = idSituacaoEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacaoEvento != null ? idSituacaoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DefSituacaoEvento)) {
            return false;
        }
        DefSituacaoEvento other = (DefSituacaoEvento) object;
        if ((this.idSituacaoEvento == null && other.idSituacaoEvento != null) || (this.idSituacaoEvento != null && !this.idSituacaoEvento.equals(other.idSituacaoEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Defsituacaoevento[ idSituacaoEvento=" + idSituacaoEvento + " ]";
    }
    
}
