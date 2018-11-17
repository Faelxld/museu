package com.web.museu.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    @OneToOne
    @JoinTable(name="entidade_tipo",
            joinColumns={@JoinColumn(name="entidade_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="tipo_id",
                    referencedColumnName="id")})
    private TipoEntidade tipoEntidade;
    @ManyToMany
    private List<Peca> pecas;

    public Entidade() {}


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), tipoEntidade, pecas, Eventos);
    }

    @OneToMany
    @JoinTable(name="entidade_evento",
            joinColumns={@JoinColumn(name="entidade_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="evento_id",
                    referencedColumnName="id")})
    private List<Evento> Eventos;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoEntidade getIdTipoEntidade() {
        return tipoEntidade;
    }

    public void setIdTipoEntidade(TipoEntidade idTipoEntidade) {
        this.tipoEntidade = idTipoEntidade;
    }


}
