package com.gft.gerenciareventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.gerenciareventos.entities.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

}
