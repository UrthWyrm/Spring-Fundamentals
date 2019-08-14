package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloHumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String searchQuery, String searchQuery2) {
		if(searchQuery == null) {
			return "Hello Human";
	 } 	else {
			return "Hello " + searchQuery + searchQuery2;
	 }
	}

}
