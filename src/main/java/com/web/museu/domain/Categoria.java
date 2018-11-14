package com.web.museu.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descricao;
    @OneToMany
    @JoinTable(name="peca_categoria",
            joinColumns={@JoinColumn(name="categoria_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")})
    private List<Peca> Pecas;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}