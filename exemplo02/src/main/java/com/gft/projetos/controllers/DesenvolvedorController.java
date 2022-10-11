package com.gft.projetos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.projetos.entities.Desenvolvedor;
import com.gft.projetos.services.DesenvolvedorService;

@Controller
@RequestMapping("desenvolvedor")
public class DesenvolvedorController {

	@Autowired
	private DesenvolvedorService desenvolvedorService;

	@RequestMapping(path = "novo")
	public ModelAndView novoDesenvolvedor() {
		ModelAndView mv = new ModelAndView("desenvolvedor/form.html");
		mv.addObject("desenvolvedor", new Desenvolvedor());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView salvarDesenvolvedor(@Valid Desenvolvedor desenvolvedor, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("desenvolvedor/novo.html");

		if (bindingResult.hasErrors()) {
			mv.addObject("desenvolvedor", desenvolvedor);
			return mv;
		}

		Desenvolvedor desenvolvedorSalvo = desenvolvedorService.salvarDesenvolvedor(desenvolvedor);
		if (desenvolvedor.getId() == null) {
			mv.addObject("desenvolvedor", new Desenvolvedor());
		} else {
			mv.addObject("desenvolvedor", desenvolvedorSalvo);
		}

		mv.addObject("mensagem", "Desenvolvedor salvo com sucesso!");
		return mv;
	}

	@RequestMapping
	public ModelAndView listarDesenvolvedores() {
		ModelAndView mv = new ModelAndView("desenvolvedor/listar.html");
		mv.addObject("lista", desenvolvedorService.listarDesenvolvedores());

		return mv;
	}

	@RequestMapping("/editar")
	public ModelAndView editarDesenvolvedor(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("desenvolvedor/form.html");
		Desenvolvedor desenvolvedor;

		try {
			desenvolvedor = desenvolvedorService.obterDesenvolvedor(id);
		} catch (Exception e) {
			desenvolvedor = new Desenvolvedor();
			mv.addObject("mensagem", e.getMessage());
		}

		mv.addObject("desenvolvedor", desenvolvedor);

		return mv;
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirDesenvolvedor(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/desenvolvedor");

		try {
			desenvolvedorService.excluirDesenvolvedor(id);
			redirectAttributes.addFlashAttribute("mensagem", "Desenvolvedor excluído com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir desenvolvedor " + e.getMessage());
		}

		return mv;
	}
}
