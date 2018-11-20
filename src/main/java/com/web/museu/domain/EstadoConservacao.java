/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "EstadoConservacao")
public class EstadoConservacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idEstadoConservacao")
    private Integer idEstadoConservacao;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idEstadoConservacao")
    private Collection<Peca> pecaCollection;

    public EstadoConservacao() {
    }
    public EstadoConservacao(Integer idEstadoConservacao, String descricao){
        this.setIdEstadoConservacao(idEstadoConservacao);
        this.setDescricao(descricao);
    }

    public EstadoConservacao(Integer idEstadoConservacao) {
        this.idEstadoConservacao = idEstadoConservacao;
    }

    public Integer getIdEstadoConservacao() {
        return idEstadoConservacao;
    }

    public void setIdEstadoConservacao(Integer idEstadoConservacao) {
        this.idEstadoConservacao = idEstadoConservacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Peca> getPecaCollection() {
        return pecaCollection;
    }

    public void setPecaCollection(Collection<Peca> pecaCollection) {
        this.pecaCollection = pecaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoConservacao != null ? idEstadoConservacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EstadoConservacao)) {
            return false;
        }
        EstadoConservacao other = (EstadoConservacao) object;
        if ((this.idEstadoConservacao == null && other.idEstadoConservacao != null) || (this.idEstadoConservacao != null && !this.idEstadoConservacao.equals(other.idEstadoConservacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estadoconservacao[ idEstadoConservacao=" + idEstadoConservacao + " ]";
    }
    
}
