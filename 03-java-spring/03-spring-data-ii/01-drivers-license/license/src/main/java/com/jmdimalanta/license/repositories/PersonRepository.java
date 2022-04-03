package com.jmdimalanta.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmdimalanta.license.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	//Get all person's from the DB.
	List<Person> findAll();
}
