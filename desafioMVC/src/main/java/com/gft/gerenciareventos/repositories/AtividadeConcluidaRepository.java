package com.gft.gerenciareventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.gerenciareventos.entities.AtividadeConcluida;

@Repository
public interface AtividadeConcluidaRepository extends JpaRepository<AtividadeConcluida, Long>{

}
