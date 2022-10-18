package com.gft.gerenciareventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.gerenciareventos.entities.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	
}
