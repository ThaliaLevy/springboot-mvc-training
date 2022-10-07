package com.gft.treinamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.treinamento.entities.Person;
import com.gft.treinamento.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;

	public Person createPerson() {
		Person person = new Person();
		
		person.setName("David");
		person.setAge(20);
		person.setStatus(true);
		
		return person;
	}
	
	public void savePerson(Person person) {
		personRepository.save(person);
	}
}
