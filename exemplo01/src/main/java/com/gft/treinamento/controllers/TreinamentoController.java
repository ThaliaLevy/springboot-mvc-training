package com.gft.treinamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TreinamentoController {

	@RequestMapping(method = RequestMethod.GET, path = "/index")
	public ModelAndView index() {
		System.out.println("to no index");
		return new ModelAndView("index.html");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/about")
	public ModelAndView about() {
		System.out.println("to no about");
		return new ModelAndView("about.html");
	}
}
