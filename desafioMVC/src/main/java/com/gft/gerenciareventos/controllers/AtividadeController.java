package com.gft.gerenciareventos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.gerenciareventos.entities.Atividade;
import com.gft.gerenciareventos.services.AtividadeService;

@Controller
@RequestMapping("atividade")
public class AtividadeController {

	@Autowired
	private AtividadeService atividadeService;

	@RequestMapping(path = "novo")
	public ModelAndView exibirTelaNovaAtividade() {
		ModelAndView mv = new ModelAndView("atividade/form.html");

		mv.addObject("atividade", new Atividade());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView cadastrarNovaAtividade(@Valid Atividade atividade, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("atividade/form.html");

		boolean atividadeExistente = false;

		if (atividade.getId() != null) {
			atividadeExistente = true;
		}

		if (bindingResult.hasErrors()) {
			mv.addObject("atividade", atividade);
			mv.addObject("mensagemErro", "*Campos obrigatórios não preenchidos.");
			return mv;
		}

		atividadeService.salvarAtividade(atividade);

		if (atividadeExistente) {
			mv.addObject("atividade", atividade);
			mv.addObject("mensagem", "Atividade editada com sucesso!");
		} else {
			mv.addObject("atividade", new Atividade());
			mv.addObject("mensagem", "Atividade salva com sucesso!");
		}

		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarAtividades() {
		ModelAndView mv = new ModelAndView("atividade/listar.html");

		mv.addObject("listaAtividades", atividadeService.listarTodasAsAtividades());
		mv.addObject("atividade", new Atividade());
		return mv;
	}

	@RequestMapping(path = "editar")
	public ModelAndView editarAtividade(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("atividade/form.html");

		mv.addObject("atividade", atividadeService.editarAtividade(id));
		return mv;
	}

	@RequestMapping(path = "excluir")
	public ModelAndView excluirAtividade(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("atividade/listar.html");

		atividadeService.excluirAtividade(id);

		mv.addObject("listaAtividades", atividadeService.listarTodasAsAtividades());
		mv.addObject("mensagem", "Atividade excluído com sucesso!");
		return mv;
	}
}
