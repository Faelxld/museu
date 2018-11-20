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
@Table(name = "Ordem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordem.findAll", query = "SELECT o FROM Ordem o")
    , @NamedQuery(name = "Ordem.findByIdOrdem", query = "SELECT o FROM Ordem o WHERE o.idOrdem = :idOrdem")
    , @NamedQuery(name = "Ordem.findByDescricao", query = "SELECT o FROM Ordem o WHERE o.descricao = :descricao")})
public class Ordem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idOrdem")
    private Integer idOrdem;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "ordem")
    private Collection<Peca> pecaCollection;

    public Ordem() {
    }
    public Ordem(Integer idOrdem, String descricao){
        this.idOrdem = idOrdem;
        this.descricao = descricao;
    }
    public Ordem(Integer idOrdem) {
        this.idOrdem = idOrdem;
    }

    public Integer getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(Integer idOrdem) {
        this.idOrdem = idOrdem;
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
        hash += (idOrdem != null ? idOrdem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordem)) {
            return false;
        }
        Ordem other = (Ordem) object;
        if ((this.idOrdem == null && other.idOrdem != null) || (this.idOrdem != null && !this.idOrdem.equals(other.idOrdem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ordem[ idOrdem=" + idOrdem + " ]";
    }
    
}
