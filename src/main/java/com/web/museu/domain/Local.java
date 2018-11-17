package com.web.museu.domain;

import javax.persistence.*;
import java.util.List;
@Entity
public class Local {

    private static final long serialVersionUID = 1L;
    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String descricao;
    @OneToMany
    @JoinTable(name="evento_local",
            joinColumns={@JoinColumn(name="local_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="evento_id",
                    referencedColumnName="id")})
    private List<Evento> Eventos;

    public Local(){}

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
