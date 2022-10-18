package com.gft.gerenciareventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.gerenciareventos.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
