package com.filmotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.filmotheque.model.Avis;
import com.filmotheque.model.Film;
import com.filmotheque.service.DetailService;

@Controller
@RequestMapping(path="/detail")
public class DetailController {

	private DetailService service;

	@Autowired
	public DetailController(DetailService service) {
		this.service = service;
	}

	@RequestMapping(path="")
	public String detail(Model model) {

//		if(ratingNumber != null &&  ratingText != null) {
//			System.out.println(ratingText);
//		}
//		
		Film f = this.service.getFilm(0);

		model.addAttribute("film", f);

		return "/detail";
	}
	
	@RequestMapping(path="/avis")
	public String detail(
			@RequestParam(required=true) String ratingNumber, 
			@RequestParam(required=true) String ratingText
			) {
		
		try {
			int finalNumber = Integer.valueOf(ratingNumber);
			String finalText = ratingText;
			
			Avis a = new Avis(finalNumber, finalText);
			
			this.service.addAvis(a, 0);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/detail";
		
	}
	
}