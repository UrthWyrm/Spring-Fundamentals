package com.codingdojo.theCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(@ModelAttribute("wrong") String wrong) {
		System.out.println(wrong);
		return "index.jsp";
	}
	@RequestMapping(path="/code", method=RequestMethod.POST)
	public String login(@RequestParam(value="code") String code, RedirectAttributes wrong) {
		if(code.equals("bushido")) {
			return "/code.jsp";
		}
		else {
	        wrong.addFlashAttribute("error", "You must train harder!");
	        return "redirect:/";
			}
		
	}

}
