package com.web.museu.repositories;

import com.web.museu.domain.EstadoConservacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoConservacaoRepository extends JpaRepository<EstadoConservacao, Integer> {

}
