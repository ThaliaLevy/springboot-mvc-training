package com.gft.gerenciareventos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.gerenciareventos.entities.Participante;
import com.gft.gerenciareventos.services.ParticipanteService;

@Controller
@RequestMapping("participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;

	@RequestMapping(path = "novo")
	public ModelAndView exibirTelaNovoParticipante() {
		ModelAndView mv = new ModelAndView("participante/form.html");

		mv.addObject("participante", new Participante());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView cadastrarNovoParticipante(@Valid Participante participante, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("participante/form.html");

		boolean participanteExistente = false;

		if (participante.getId() != null) {
			participanteExistente = true;
		}

		if (bindingResult.hasErrors()) {
			mv.addObject("participante", participante);
			mv.addObject("mensagemErro", "*Campos obrigatórios não preenchidos.");
			return mv;
		}

		participanteService.salvarParticipante(participante);

		if (participanteExistente) {
			mv.addObject("participante", participante);
			mv.addObject("mensagem", "Participante editado com sucesso!");
		} else {
			mv.addObject("participante", new Participante());
			mv.addObject("mensagem", "Participante salvo com sucesso!");
		}

		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarParticipantes() {
		ModelAndView mv = new ModelAndView("participante/listar.html");

		mv.addObject("listaParticipantes", participanteService.listarTodosOsParticipantes());
		mv.addObject("participante", new Participante());
		return mv;
	}

	@RequestMapping(path = "editar")
	public ModelAndView editarParticipante(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("participante/form.html");

		mv.addObject("participante", participanteService.editarParticipante(id));
		return mv;
	}

	@RequestMapping(path = "excluir")
	public ModelAndView excluirParticipante(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("participante/listar.html");

		participanteService.excluirParticipante(id);

		mv.addObject("listaParticipantes", participanteService.listarTodosOsParticipantes());
		mv.addObject("mensagem", "Participante excluído com sucesso!");
		return mv;
	}
}
