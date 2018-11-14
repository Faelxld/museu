package com.web.museu.repositories;

import com.web.museu.domain.Categoria;
import com.web.museu.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento,  Integer> {

}
