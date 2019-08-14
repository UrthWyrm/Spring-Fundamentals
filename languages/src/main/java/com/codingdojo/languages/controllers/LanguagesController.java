package com.codingdojo.languages.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.services.LanguagesService;
@Controller
public class LanguagesController {
	private final LanguagesService languagesService;

    public LanguagesController(LanguagesService languagesService){
        this.languagesService = languagesService;
    }

    @RequestMapping("/languages")
    public String home(@ModelAttribute("language") Languages language, Model model){
        Iterable<Languages> languages = languagesService.allLanguages();
        model.addAttribute("languages", languages);
        return "/WEB-INF/views/languages.jsp";
    }
    @PostMapping("/languages")
    public String newLanguage(@Valid @ModelAttribute("language") Languages language, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/languages.jsp";
        }else{
            languagesService.addLanguage(language);
            return "redirect:/languages";
        }
    }
    @RequestMapping("/languages/delete/{id}")
    public String deleteLanguage(@PathVariable("id") Long id){
        languagesService.deleteLanguage(id);
        return "redirect:/languages";
    }
    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model){
    	Optional<Languages> language = languagesService.getLanguagesByID(id);
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        return "/WEB-INF/views/editLanguage.jsp";
    }
    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Languages language, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/editLanguage.jsp";
        }else{
            languagesService.editLanguage(language);
            return "redirect:/languages";
        }
    }
    @RequestMapping("/languages/{id}")
    public String getLanguge(@PathVariable("id") Long id, Model model){
        Optional<Languages> language = languagesService.getLanguagesByID(id);
        model.addAttribute("language", language);
        return "/WEB-INF/views/language.jsp";
    }

}
