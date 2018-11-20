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

/**
 *
 * @author Denner
 */
@Entity
@Table(name = "Regiao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regiao.findAll", query = "SELECT r FROM Regiao r")
    , @NamedQuery(name = "Regiao.findByIdRegiao", query = "SELECT r FROM Regiao r WHERE r.idRegiao = :idRegiao")
    , @NamedQuery(name = "Regiao.findByDescricao", query = "SELECT r FROM Regiao r WHERE r.descricao = :descricao")})
public class Regiao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegiao")
    private Integer idRegiao;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idRegiao")
    private Collection<Peca> pecaCollection;

    public Regiao() {
    }

    public Regiao(Integer idRegiao) {
        this.idRegiao = idRegiao;
    }
    public Regiao(Integer idRegiao, String descricao ){
        this.setIdRegiao(idRegiao);
        this.setDescricao(descricao);
    }

    public Integer getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Integer idRegiao) {
        this.idRegiao = idRegiao;
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
        hash += (idRegiao != null ? idRegiao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regiao)) {
            return false;
        }
        Regiao other = (Regiao) object;
        if ((this.idRegiao == null && other.idRegiao != null) || (this.idRegiao != null && !this.idRegiao.equals(other.idRegiao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Regiao[ idRegiao=" + idRegiao + " ]";
    }
    
}
