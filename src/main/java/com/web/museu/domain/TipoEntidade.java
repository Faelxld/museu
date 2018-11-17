package com.web.museu.domain;

import javax.persistence.*;
import java.util.List;
@Entity
public class TipoEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;
    @OneToMany
    @JoinTable(name="entidade_tipo",
            joinColumns={@JoinColumn(name="tipo_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="entidade_id",
                    referencedColumnName="id")})
    private List<Entidade> Entidades;

    public TipoEntidade(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
