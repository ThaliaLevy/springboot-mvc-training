package com.gft.treinamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.treinamento.entities.Person;
import com.gft.treinamento.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(method = RequestMethod.GET, path = "/new")
	public ModelAndView formPerson() {
		ModelAndView mv = new ModelAndView("formPerson.html");

		mv.addObject("person", new Person());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getPerson() {
		ModelAndView mv = new ModelAndView("person.html");

		mv.addObject("person", personService.createPerson());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView newPerson(Person person) {
		ModelAndView mv = new ModelAndView("person.html");

		mv.addObject("person", person);
		return mv;
	}

}
