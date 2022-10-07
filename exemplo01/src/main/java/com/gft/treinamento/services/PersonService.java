package com.gft.treinamento.services;

import org.springframework.stereotype.Service;

import com.gft.treinamento.entities.Person;

@Service
public class PersonService {

	public Person createPerson() {
		Person person = new Person();
		
		person.setName("David");
		person.setAge(20);
		person.setStatus(true);
		
		return person;
	}
}
