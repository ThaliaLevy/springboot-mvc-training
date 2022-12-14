package com.gft.treinamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(method = RequestMethod.GET, path = "/edit")
	public ModelAndView editPerson(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("formPerson.html");

		try {
			mv.addObject("person", personService.getPerson(id));
		} catch (Exception e) {
			mv.addObject("message", e.getMessage());
		}
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ModelAndView getPerson(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("person.html");

		try {
			mv.addObject("person", personService.getPerson(id));
			// mv.addObject("person", personService.createPerson());
		} catch (Exception e) {
			mv.addObject("message", e.getMessage());
		}
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView newPerson(Person person, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/person");

		person = personService.savePerson(person);
		redirectAttributes.addFlashAttribute("message", "Pessoa salva com sucesso!");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/delete")
	public ModelAndView deletePerson(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		//ModelAndView mv = new ModelAndView("forward:/person");	//uma forma de redirecionamento do spring 
		ModelAndView mv = new ModelAndView("redirect:/person");	//outra forma de redirecionamento do spring 

		try {
			personService.deletePerson(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		redirectAttributes.addFlashAttribute("message", id + " exclu??do!");
		return mv;
	}


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listPerson() {
		ModelAndView mv = new ModelAndView("listPerson.html");

		mv.addObject("list", personService.listPerson());
		return mv;
	}

}
