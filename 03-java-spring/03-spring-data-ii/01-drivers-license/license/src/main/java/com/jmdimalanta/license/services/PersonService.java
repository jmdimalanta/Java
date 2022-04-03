package com.jmdimalanta.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdimalanta.license.models.Person;
import com.jmdimalanta.license.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository pRepository;
	
	//list all person
	public List<Person> allPersons(){
		return pRepository.findAll();
	}
	//Create a person
	public Person createPerson(Person newPerson) {
		return this.pRepository.save(newPerson);
	}
	//One Person Detail
	public Person findPerson(Long id) {
		return pRepository.findById(id).orElse(null);
	}
}
