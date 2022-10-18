package com.gft.gerenciareventos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.gerenciareventos.entities.Administrador;
import com.gft.gerenciareventos.services.AdministradorService;

@Controller
@RequestMapping("administrador")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	@RequestMapping(path = "novo")
	public ModelAndView exibirTelaNovoAdministrador() {
		ModelAndView mv = new ModelAndView("administrador/form.html");

		mv.addObject("administrador", new Administrador());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView cadastrarNovoAdministrador(@Valid Administrador administrador, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("administrador/form.html");

		boolean administradorExistente = false;

		if (administrador.getId() != null) {
			administradorExistente = true;
		}

		if (bindingResult.hasErrors()) {
			mv.addObject("administrador", administrador);
			mv.addObject("mensagemErro", "*Campos obrigatórios não preenchidos.");
			return mv;
		}

		administradorService.salvarAdministrador(administrador);

		if (administradorExistente) {
			mv.addObject("administrador", administrador);
			mv.addObject("mensagem", "Administrador editado com sucesso!");
		} else {
			mv.addObject("administrador", new Administrador());
			mv.addObject("mensagem", "Administrador salvo com sucesso!");
		}

		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarAdministrador() {
		ModelAndView mv = new ModelAndView("administrador/listar.html");

		mv.addObject("listaAdministradores", administradorService.listarTodosOsAdministradores());
		mv.addObject("administrador", new Administrador());
		return mv;
	}

	@RequestMapping(path = "editar")
	public ModelAndView editarAdministrador(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("administrador/form.html");

		mv.addObject("administrador", administradorService.editarAdministrador(id));
		return mv;
	}

	@RequestMapping(path = "excluir")
	public ModelAndView excluiraAdministrador(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("administrador/listar.html");

		administradorService.excluirAdministrador(id);

		mv.addObject("listaAdministradores", administradorService.listarTodosOsAdministradores());
		mv.addObject("mensagem", "Administrador excluído com sucesso!");
		return mv;
	}
}
