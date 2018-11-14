package com.web.museu.repositories;

import com.web.museu.domain.SituacaoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoEventoRepository extends JpaRepository<SituacaoEvento,Integer> {

}
