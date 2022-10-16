package com.gft.desafio.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Espécie do pokemon não pode ser vazia.")
	private String especieDoPokemon;
	
	@NotEmpty(message = "Tipo do pokemon não pode ser vazio.")
	private String tipoDoPokemon;
	//private List<Poder> poderes;
	
	public String getEspecieDoPokemon() {
		return especieDoPokemon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEspecieDoPokemon(String especieDoPokemon) {
		this.especieDoPokemon = especieDoPokemon;
	}

	public String getTipoDoPokemon() {
		return tipoDoPokemon;
	}

	public void setTipoDoPokemon(String tipoDoPokemon) {
		this.tipoDoPokemon = tipoDoPokemon;
	}

/*	public List<Poder> getPoderes() {
		return poderes;
	}

	public void setPoderes(List<Poder> poderes) {
		this.poderes = poderes;
	}*/
}
