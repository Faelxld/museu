/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.museu.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Peca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peca.findAll", query = "SELECT p FROM Peca p")
    , @NamedQuery(name = "Peca.findByIdPeca", query = "SELECT p FROM Peca p WHERE p.idPeca = :idPeca")
    , @NamedQuery(name = "Peca.findByDataCadastro", query = "SELECT p FROM Peca p WHERE p.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Peca.findByData", query = "SELECT p FROM Peca p WHERE p.data = :data")
    , @NamedQuery(name = "Peca.findByObservacao", query = "SELECT p FROM Peca p WHERE p.observacao = :observacao")
    , @NamedQuery(name = "Peca.findByCodigoInterno", query = "SELECT p FROM Peca p WHERE p.codigoInterno = :codigoInterno")
    , @NamedQuery(name = "Peca.findByDescricao", query = "SELECT p FROM Peca p WHERE p.descricao = :descricao")})
public class Peca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPeca")
    private Integer idPeca;
    @Column(name = "dataCadastro")
    private Date dataCadastro;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "codigoInterno")
    private String codigoInterno;
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "doador", referencedColumnName = "idEntidade")
    @ManyToOne
    private Entidade doador;
    @JoinColumn(name = "idRegiao", referencedColumnName = "idRegiao")
    @ManyToOne
    private Regiao idRegiao;
    @JoinColumn(name = "familia", referencedColumnName = "idFamilia")
    @ManyToOne
    private Familia familia;
    @JoinColumn(name = "idEstadoConservacao", referencedColumnName = "idEstadoConservacao")
    @ManyToOne
    private EstadoConservacao idEstadoConservacao;
    @JoinColumn(name = "ordem", referencedColumnName = "idOrdem")
    @ManyToOne
    private Ordem ordem;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "classe", referencedColumnName = "idClasse")
    @ManyToOne
    private Classe classe;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento")
    @ManyToOne
    private Evento evento;

    public Peca() {
    }

    public Peca(Integer id, Date dataCadastro, Date data, String observacao, String codigoInterno, String descricao, Entidade doador, Regiao idRegiao, Ordem ordem, Familia familia, Classe classe, Categoria idCategoria, EstadoConservacao idEstadoConservacao) {
        this.idPeca = id;
        this.dataCadastro = dataCadastro;
        this.data = data;
        this.observacao = observacao;
        this.codigoInterno = codigoInterno;
        this.descricao = descricao;
        this.evento = evento;
        this.doador = doador;
        this.idRegiao = idRegiao;
        this.ordem = ordem;
        this.familia = familia;
        this.classe = classe;
        this.idCategoria = idCategoria;
        this.idEstadoConservacao = idEstadoConservacao;
    }
    public Peca(Integer idPeca) {
        this.idPeca = idPeca;
    }

    public Integer getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Integer idPeca) {
        this.idPeca = idPeca;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Entidade getDoador() {
        return doador;
    }

    public void setDoador(Entidade doador) {
        this.doador = doador;
    }

    public Regiao getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Regiao idRegiao) {
        this.idRegiao = idRegiao;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public EstadoConservacao getIdEstadoConservacao() {
        return idEstadoConservacao;
    }

    public void setIdEstadoConservacao(EstadoConservacao idEstadoConservacao) {
        this.idEstadoConservacao = idEstadoConservacao;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeca != null ? idPeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peca)) {
            return false;
        }
        Peca other = (Peca) object;
        if ((this.idPeca == null && other.idPeca != null) || (this.idPeca != null && !this.idPeca.equals(other.idPeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Peca[ idPeca=" + idPeca + " ]";
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
