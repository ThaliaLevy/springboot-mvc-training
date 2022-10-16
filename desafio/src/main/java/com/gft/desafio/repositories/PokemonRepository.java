package com.gft.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.desafio.entities.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
