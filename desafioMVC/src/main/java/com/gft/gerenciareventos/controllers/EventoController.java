package com.gft.gerenciareventos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.gerenciareventos.entities.Evento;
import com.gft.gerenciareventos.services.AtividadeService;
import com.gft.gerenciareventos.services.EventoService;
import com.gft.gerenciareventos.services.GrupoService;

@Controller
@RequestMapping("evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private AtividadeService atividadeService;

	@RequestMapping(path = "novo")
	public ModelAndView exibirTelaNovoEvento() {
		ModelAndView mv = new ModelAndView("evento/form.html");

		mv.addObject("listaGrupos", grupoService.listarTodosOsGrupos());
		mv.addObject("listaAtividades", atividadeService.listarTodasAsAtividades());
		mv.addObject("evento", new Evento());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView cadastrarNovoEvento(@Valid Evento evento, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("evento/form.html");
		mv.addObject("listaGrupos", grupoService.listarTodosOsGrupos());
		mv.addObject("listaAtividades", atividadeService.listarTodasAsAtividades());

		boolean eventoExistente = false;

		if (evento.getId() != null) {
			eventoExistente = true;
		}

		if (bindingResult.hasErrors()) {
			mv.addObject("evento", evento);
			mv.addObject("mensagemErro", "*Campos obrigatórios não preenchidos.");
			return mv;
		}

		eventoService.salvarEvento(evento);

		if (eventoExistente) {
			mv.addObject("mensagem", "Evento editado com sucesso!");
		} else {
			mv.addObject("mensagem", "Evento salvo com sucesso!");
		}

		mv.addObject("evento", new Evento());
		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarEventos() {
		ModelAndView mv = new ModelAndView("evento/listar.html");

		mv.addObject("listaEventos", eventoService.listarTodosOsEventos());
		return mv;
	}

	@RequestMapping(path = "editar")
	public ModelAndView editarEvento(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("evento/form.html");

		mv.addObject("listaGrupos", grupoService.listarTodosOsGrupos());
		mv.addObject("listaAtividades", atividadeService.listarTodasAsAtividades());
		mv.addObject("evento", eventoService.editarEvento(id));
		return mv;
	}

	@RequestMapping(path = "excluir")
	public ModelAndView excluirEvento(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("evento/listar.html");

		eventoService.excluirEvento(id);

		mv.addObject("listaEventos", eventoService.listarTodosOsEventos());
		mv.addObject("mensagem", "Evento excluído com sucesso!");
		return mv;
	}
}
