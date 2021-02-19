package com.filmotheque.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(path="/{id}")
	public String detail(@PathVariable int id, Model model) {
		Film f = this.service.getFilm(id);

		model.addAttribute("film", f);

		return "/detail";
	}
	
	@RequestMapping(path="/avis")
	public String detail(
			@RequestParam(required=true) String ratingNumber, 
			@RequestParam(required=true) String ratingText,
			HttpServletRequest request
			) {
		try {
			int finalNumber = Integer.valueOf(ratingNumber);
			String finalText = ratingText;
			
			Avis a = new Avis(finalNumber, finalText);
			
			this.service.addAvis(a, 0);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		String previousPath = request.getHeader("Referer");
		String id = previousPath.substring(previousPath.lastIndexOf('/') + 1);
		
		return "redirect:/detail/" + id;
		
	}
	
}