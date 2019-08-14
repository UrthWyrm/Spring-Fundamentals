package com.codingdojo.gettingfamiliar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gettingFamiliarController {
	@RequestMapping("/dojo")
	public String dojo() {
		return "The dojo is awesome!";
	}
	@RequestMapping("/burbank-dojo/")
	public String burbank() {
		return "Burbank Dojo is located in Southern California.";
	}
	@RequestMapping("/san-jose/")
	public String sanJose() {
		return "SJ dojo is the headquarters.";
	}
	
	
}
