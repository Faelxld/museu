package com.web.museu.repositories;

import com.web.museu.domain.TipoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEntidadeRepository extends JpaRepository<TipoEntidade, Integer> {

}
