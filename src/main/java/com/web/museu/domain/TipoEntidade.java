/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.museu.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Denner
 */
@Entity
@Table(name = "TipoEntidade")
public class TipoEntidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoEntidade")
    private Integer idTipoEntidade;
    @Column(name = "descricao")
    private String descricao;

    public TipoEntidade() {
    }
    public TipoEntidade(Integer idTipoEntidade, String descricao){
        this.setIdTipoEntidade(idTipoEntidade);
        this.setDescricao(descricao);
    }
    public TipoEntidade(Integer idTipoEntidade) {
        this.idTipoEntidade = idTipoEntidade;
    }

    public Integer getIdTipoEntidade() {
        return idTipoEntidade;
    }

    public void setIdTipoEntidade(Integer idTipoEntidade) {
        this.idTipoEntidade = idTipoEntidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEntidade != null ? idTipoEntidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEntidade)) {
            return false;
        }
        TipoEntidade other = (TipoEntidade) object;
        if ((this.idTipoEntidade == null && other.idTipoEntidade != null) || (this.idTipoEntidade != null && !this.idTipoEntidade.equals(other.idTipoEntidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoEntidade[ idTipoEntidade=" + idTipoEntidade + " ]";
    }
    
}
