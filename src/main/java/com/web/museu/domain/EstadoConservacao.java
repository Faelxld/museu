package com.web.museu.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class EstadoConservacao {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String descricao;
    @OneToMany
    @JoinTable(name="peca_EstadoConservacao",
            joinColumns={@JoinColumn(name="EstadoConservacao_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="peca_id",
                    referencedColumnName="id")})
    private List<Peca> Pecas;



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
