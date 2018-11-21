package com.web.museu.dto;


import com.web.museu.domain.Categoria;
import com.web.museu.domain.Classe;
import com.web.museu.domain.Entidade;
import com.web.museu.domain.EstadoConservacao;
import com.web.museu.domain.Evento;
import com.web.museu.domain.Familia;
import com.web.museu.domain.Ordem;
import com.web.museu.domain.Peca;
import com.web.museu.domain.Regiao;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class PecaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer  id;
    private Date dataCadastro;
    private Date data;
    private String observacao;
    private String codigoInterno;
    private String descricao;
    private Evento evento;
    private Entidade doador;
    private Regiao idRegiao;
    private Ordem ordem;
    private Familia familia;
    private Classe classe;
    private Categoria idCategoria;
    private EstadoConservacao idEstadoConservacao;

    public PecaDTO() {
    }

    public PecaDTO(Peca obj) {
        this.setId(obj.getIdPeca());
        this.setDataCadastro(obj.getDataCadastro());
        this.setData(obj.getData());
        this.setObservacao(obj.getObservacao());
        this.setCodigoInterno(obj.getCodigoInterno());
        this.setDescricao(obj.getDescricao());
        this.setEvento(obj.getEvento());
        this.setDoador(obj.getDoador());
        this.setIdRegiao(obj.getIdRegiao());
        this.setOrdem(obj.getOrdem());
        this.setFamilia(obj.getFamilia());
        this.setClasse(obj.getClasse());
        this.setIdCategoria(obj.getIdCategoria());
        this.setIdEstadoConservacao(obj.getIdEstadoConservacao());
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public EstadoConservacao getIdEstadoConservacao() {
        return idEstadoConservacao;
    }

    public void setIdEstadoConservacao(EstadoConservacao idEstadoConservacao) {
        this.idEstadoConservacao = idEstadoConservacao;
    }
}
