package com.gft.gerenciareventos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.gerenciareventos.entities.Grupo;
import com.gft.gerenciareventos.services.GrupoService;
import com.gft.gerenciareventos.services.ParticipanteService;

@Controller
@RequestMapping("grupo")
public class GrupoController {
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private ParticipanteService participanteService;

	@RequestMapping(path = "novo")
	public ModelAndView exibirTelaNovoGrupo() {
		ModelAndView mv = new ModelAndView("grupo/form.html");

		mv.addObject("listaParticipantes", participanteService.listarTodosOsParticipantes());
		mv.addObject("grupo", new Grupo());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView cadastrarNovoGrupo(@Valid Grupo grupo, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("grupo/form.html");
		mv.addObject("listaParticipantes", participanteService.listarTodosOsParticipantes());
		
		boolean grupoExistente = false;

		if (grupo.getId() != null) {
			grupoExistente = true;
		}

		if (bindingResult.hasErrors()) {
			mv.addObject("grupo", grupo);
			mv.addObject("mensagemErro", "*Campos obrigatórios não preenchidos.");
			return mv;
		}

		grupoService.salvarGrupo(grupo);

		if (grupoExistente) {
			mv.addObject("mensagem", "Grupo editado com sucesso!");
		} else {
			mv.addObject("mensagem", "Grupo salvo com sucesso!");
		}

		mv.addObject("grupo", new Grupo());
		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarGrupos() {
		ModelAndView mv = new ModelAndView("grupo/listar.html");

		mv.addObject("listaGrupos", grupoService.listarTodosOsGrupos());
		return mv;
	}

	@RequestMapping(path = "editar")
	public ModelAndView editarGrupo(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("grupo/form.html");

		mv.addObject("listaParticipantes", participanteService.listarTodosOsParticipantes());
		mv.addObject("participantesGrupo", grupoService.editarGrupo(id));
		mv.addObject("grupo", grupoService.editarGrupo(id));
		return mv;
	}

	@RequestMapping(path = "excluir")
	public ModelAndView excluirGrupo(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("grupo/listar.html");

		grupoService.excluirGrupo(id);

		mv.addObject("listaGrupos", grupoService.listarTodosOsGrupos());
		mv.addObject("mensagem", "Grupo excluído com sucesso!");
		return mv;
	}
}
