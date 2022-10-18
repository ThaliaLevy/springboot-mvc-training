package com.gft.gerenciareventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.gerenciareventos.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long>{

}
