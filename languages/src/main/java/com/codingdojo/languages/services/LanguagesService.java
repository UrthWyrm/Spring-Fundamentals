package com.codingdojo.languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.repositories.LanguagesRepository;

@Service
public class LanguagesService {
	
	private LanguagesRepository languagesRepository;
    public LanguagesService(LanguagesRepository languagesRepository){
        this.languagesRepository = languagesRepository;
    }
    private List<Languages> languages = new ArrayList<>(Arrays.asList(
    		new Languages("Java", "James Gosling", "1.8"),
    		new Languages("Python", "Guido van Rossum", "3.6")
            ));
    public Iterable<Languages> allLanguages(){
        return languagesRepository.findAll();
    }
    public void addLanguage(Languages language){
        languagesRepository.save(language);
    }
    public void deleteLanguage(Long index){
            languagesRepository.deleteById(index);

    }
    public Optional<Languages> getLanguagesByID(Long index){
        return languagesRepository.findById(index);
    }
    public void editLanguage(Languages language){
        languagesRepository.save(language);
    }

}
