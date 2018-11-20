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
    private List<Evento> Eventos;

    public SituacaoEvento(){}

    public SituacaoEvento(int id, String descricao, List<Evento> Eventos) {
        this.id = id;
        this.descricao = descricao;
        this.Eventos = Eventos;
    }
    
    
    

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

    public List<Evento> getEventos() {
        return Eventos;
    }

    public void setEventoss(List<Evento> Eventos) {
        this.Eventos = Eventos;
    }
    
    
}
