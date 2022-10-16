package com.gft.desafio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.desafio.entities.Pokemon;
import com.gft.desafio.services.PokemonService;

@Controller
@RequestMapping("pokemon")
class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;

	@RequestMapping(path = "novo")
	public ModelAndView exibirTelaNovoPokemon() {
		ModelAndView mv = new ModelAndView("pokemon/form.html");
		
		mv.addObject("pokemon", new Pokemon());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView cadastrarNovoPokemon(@Valid Pokemon pokemon, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("pokemon/form.html"); 
		
		boolean pokemonExistente = false;
		
		if(pokemon.getId() != null) {
			pokemonExistente = true;
		}
		
		if (bindingResult.hasErrors()) {
			mv.addObject("pokemon", pokemon);
			mv.addObject("mensagemErro", "*Campos obrigatórios não preenchidos.");
			return mv;
		}

		pokemonService.salvarPokemon(pokemon);
		
		if(pokemonExistente) {
			mv.addObject("pokemon", pokemon);
			mv.addObject("mensagem", "Pokemon editado com sucesso!");
		} else {
			mv.addObject("pokemon", new Pokemon());
			mv.addObject("mensagem", "Pokemon salvo com sucesso!");
		}

		return mv;
	}
	
	@RequestMapping(path = "listar")
	public ModelAndView listarPokemons() {
		ModelAndView mv = new ModelAndView("pokemon/listar.html");
		
		mv.addObject("listaPokemons", pokemonService.listarTodosOsPokemons());
		mv.addObject("pokemon", new Pokemon());
		return mv;
	}
	
	@RequestMapping(path = "editar")
	public ModelAndView editarPokemon(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("pokemon/form.html");
				
		mv.addObject("pokemon", pokemonService.editarPokemon(id));
		return mv;
	}
	
	@RequestMapping(path = "excluir")
	public ModelAndView excluirPokemon(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("pokemon/listar.html");
				
		pokemonService.excluirPokemon(id);
		
		mv.addObject("listaPokemons", pokemonService.listarTodosOsPokemons());
		mv.addObject("mensagem", "Pokemon excluído com sucesso!");
		return mv;
	}
}
