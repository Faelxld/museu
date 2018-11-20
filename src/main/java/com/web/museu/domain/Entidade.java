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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Entidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidade.findAll", query = "SELECT e FROM Entidade e")
    , @NamedQuery(name = "Entidade.findByIdEntidade", query = "SELECT e FROM Entidade e WHERE e.idEntidade = :idEntidade")
    , @NamedQuery(name = "Entidade.findByNome", query = "SELECT e FROM Entidade e WHERE e.nome = :nome")})
public class Entidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idEntidade")
    private Integer idEntidade;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idSolicitante")
    private Collection<Evento> eventoCollection;
    @OneToMany(mappedBy = "doador")
    private Collection<Peca> pecaCollection;

    public Entidade() {
    }

    public Entidade(Integer idEntidade) {
        this.idEntidade = idEntidade;
    }

    public Entidade(Integer idEntidade, String nome, TipoEntidade tipoEntidade){
        this.setIdEntidade(idEntidade);
        this.setNome(nome);
    }
    public Integer getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(Integer idEntidade) {
        this.idEntidade = idEntidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
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
        hash += (idEntidade != null ? idEntidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidade)) {
            return false;
        }
        Entidade other = (Entidade) object;
        if ((this.idEntidade == null && other.idEntidade != null) || (this.idEntidade != null && !this.idEntidade.equals(other.idEntidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Entidade[ idEntidade=" + idEntidade + " ]";
    }
    
}
