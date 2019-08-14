package com.codingdojo.languages.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.languages.models.Languages;

public interface LanguagesRepository extends CrudRepository<Languages, Long> {

}
