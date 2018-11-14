package com.web.museu.repositories;

import com.web.museu.domain.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdemRepository extends JpaRepository<Ordem, Integer> {

}
