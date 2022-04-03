package com.jmdimalanta.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.jmdimalanta.languages.models.Language;
import com.jmdimalanta.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	//returns all languages
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	//creates a language
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	//retrieves a language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	//delete a language
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	public Language updateLanguage(@Valid Language language) {
		return languageRepository.save(language);
		// TODO Auto-generated method stub
		
	}
}
