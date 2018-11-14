package com.web.museu.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Peca implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    private Date dataCadastro;
    private Date data;
    private String observacao;
    private String codigoInterno;
    private String descricao;
    @ManyToMany
    private List<Evento> eventos;
    @ManyToMany
    private List<Entidade> doador;
    @JoinTable(name="peca_regiao",
            joinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="regiao_id",
                    referencedColumnName="id")})
    private Regiao idRegiao;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="peca_ordem",
            joinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="ordem_id",
                    referencedColumnName="id")})
    private Ordem ordem;
    @OneToOne
    @JoinTable(name="peca_familia",
            joinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="familia_id",
                    referencedColumnName="id")})
    private Familia familia;
    @OneToOne
    @JoinTable(name="peca_classe",
            joinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="classe_id",
                    referencedColumnName="id")})
    private Classe classe;
    @OneToOne
    @JoinTable(name="peca_categoria",
            joinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="categoria_id",
                    referencedColumnName="id")})
    private Categoria idCategoria;
    @OneToOne
    @JoinTable(name="peca_estadoConservacao",
            joinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="estadoConservacao_id",
                    referencedColumnName="id")})
    private EstadoConservacao idEstadoConservacao;


    public int getIdPeca() {
        return id;
    }

    public void setIdPeca(int idPeca) {
        this.id = idPeca;
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
