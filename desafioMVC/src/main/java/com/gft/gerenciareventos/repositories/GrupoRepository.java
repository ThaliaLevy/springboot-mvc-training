package com.gft.gerenciareventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.gerenciareventos.entities.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

}
