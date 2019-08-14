package com.codingdojo.displayDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date mydate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d zzz yyyy");
		String formatDate = formatter.format(mydate);
		
		model.addAttribute("date", formatDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date mydate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss" );
		String formatTime = formatter.format(mydate);
		model.addAttribute("date", formatTime);
		return "time.jsp";
	}
	


}
