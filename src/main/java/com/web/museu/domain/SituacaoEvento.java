package com.web.museu.domain;
import javax.persistence.*;
import java.util.List;
@Entity
public class SituacaoEvento {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;
    @OneToMany
    @JoinTable(name="evento_situacao",
            joinColumns={@JoinColumn(name="situacao_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="evento_id",
                    referencedColumnName="id")})
    private List<Evento> Eventoss;


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
