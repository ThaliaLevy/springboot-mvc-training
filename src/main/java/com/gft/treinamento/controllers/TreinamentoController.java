package com.gft.treinamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TreinamentoController {

	@RequestMapping(method = RequestMethod.GET, path = "/index2")
	// para que parametro nao seja obrigatorio
	public ModelAndView index() {
		return new ModelAndView("index.html");
	}
	
	// anotação que identifica metodo realizado e caminho
	@RequestMapping(method = RequestMethod.GET, path = "/index")
	// para inserir parametros, usar @RequestParam
	public ModelAndView index(@RequestParam String name) {
		ModelAndView mv = new ModelAndView("index.html");
		//addObject é um dos metodos possiveis de se utilizar para manipular dados para o html
		mv.addObject("name", name);
		return mv;
	}

	// outra forma de usar @RequestParam
	@RequestMapping(method = RequestMethod.GET, path = "/about")
	public ModelAndView about(@RequestParam(name = "nomeUser") String firstName, @RequestParam Integer age) {
		System.out.println("to no about" + firstName + "tenho " + age);
		return new ModelAndView("about.html");
	}
}
