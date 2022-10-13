package com.gft.projetos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.projetos.entities.Desenvolvedor;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {

	//contains utilizado para validar caso seja escrito somente uma parte do que se quer buscar
	List<Desenvolvedor> findByNomeContains(String nome);
	
	//Contains e And precisam ser exatamente na ordem dos parametros
	List<Desenvolvedor> findByNomeContainsAndQuatroLetrasContains(String nome, String quatroLetras);
}
