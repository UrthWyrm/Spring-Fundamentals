package com.codingdojo.dojosurvey.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(){
		return "index.html";
	}
	
	@RequestMapping(path = "/results", method = RequestMethod.POST)
	public String results(HttpSession session, @RequestParam HashMap<String, String> formData, @RequestParam("language") String language) {
		session.setAttribute("data", formData);
		session.setAttribute("language", language);
		return "redirect:/results";
	}
	
	@RequestMapping(path = "/results", method = RequestMethod.GET)
	public String results(HttpSession session, Model model) {
		if(session.getAttribute("data") == null) {
			return "redirect:/";
			
		} else {
			if((session.getAttribute("language").equals("Java"))) {
				return "/WEB-INF/view/index.jsp";
			
			} else {
			return "/WEB-INF/view/results.jsp";
			}
		}
	}
	
	@RequestMapping(path="/reset", method = RequestMethod.GET)
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
	
