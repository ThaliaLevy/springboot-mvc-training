package com.gft.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.desafio.entities.Pokemon;
import com.gft.desafio.repositories.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;

	public Pokemon salvarPokemon(Pokemon pokemon) {

		return pokemonRepository.save(pokemon);
	}
	
	public List<Pokemon> listarTodosOsPokemons() {
		return pokemonRepository.findAll();
	}
	
	public Pokemon editarPokemon(Long id) {
		Optional<Pokemon> pokemon = pokemonRepository.findById(id);
		return pokemon.get();
	}
	
	public void excluirPokemon(Long id) {
		pokemonRepository.deleteById(id);
	}
}
