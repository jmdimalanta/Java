package com.jmdimalanta.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmdimalanta.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	// get all languages
	List<Language> findAll();
}
