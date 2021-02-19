package com.filmotheque.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.filmotheque.model.Avis;
import com.filmotheque.model.Film;
import com.filmotheque.service.FilmService;

@Controller
@RequestMapping(path="/detail")
public class DetailController {

	private FilmService service;
	
	@Autowired
	public DetailController(FilmService service) {
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
		
		String previousPath = request.getHeader("Referer");
		String id = previousPath.substring(previousPath.lastIndexOf('/') + 1);
		try {
			int finalNumber = Integer.valueOf(ratingNumber);
			String finalText = ratingText;
			
			Avis a = new Avis(finalNumber, finalText);
			
			this.service.addAvis(a, Long.parseLong(id));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/detail/" + id;
		
	}
	
}

