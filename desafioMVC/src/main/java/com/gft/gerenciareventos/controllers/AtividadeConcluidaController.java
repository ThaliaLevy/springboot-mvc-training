package com.gft.gerenciareventos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.gerenciareventos.entities.AtividadeConcluida;
import com.gft.gerenciareventos.services.AtividadeConcluidaService;
import com.gft.gerenciareventos.services.EventoService;

@Controller
@RequestMapping("evento")
public class AtividadeConcluidaController {

	@Autowired
	private AtividadeConcluidaService atividadeConcluidaService;

	@Autowired
	private EventoService eventoService;

	@RequestMapping(path = "controle-atividades")
	public ModelAndView exibirTelaNovoGrupo() {
		ModelAndView mv = new ModelAndView("evento/controle-atividades.html");

		mv.addObject("atividadeConcluida", new AtividadeConcluida());
		mv.addObject("listaEventos", eventoService.listarTodosOsEventos());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "controle-atividades")
	public ModelAndView cadastrarNovaAtividade(@Valid AtividadeConcluida atividadeConcluida,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("evento/controle-atividades.html");

		boolean atividadeExistente = false;

		if (atividadeConcluida.getId() != null) {
			atividadeExistente = true;
		}

		if (bindingResult.hasErrors()) {
			mv.addObject("listaEventos", eventoService.listarTodosOsEventos());
			mv.addObject("atividadeConcluida", atividadeConcluida);
			mv.addObject("mensagemErro", "*Campos obrigatórios não preenchidos.");
			return mv;
		}

		atividadeConcluidaService.salvarAtividade(atividadeConcluida);

		if (atividadeExistente) {
			mv.addObject("mensagem", "Atividade editada com sucesso!");
			mv.addObject("atividadeConcluida", atividadeConcluida);
		} else {
			mv.addObject("mensagem", "Atividade salva com sucesso!");
			mv.addObject("atividadeConcluida", new AtividadeConcluida());
		}

		mv.addObject("listaEventos", eventoService.listarTodosOsEventos());
		return mv;
	}

}
