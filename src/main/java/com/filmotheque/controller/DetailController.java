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
	

	@RequestMapping(path = "/home")
	public String home(Model model) {
		
		List<Film> films = this.service.getAllFilm();
		
		model.addAttribute("films", films);
		
		return "home";
	}
	
	@GetMapping(path="/add-film")
	public String formulaireFilm(@ModelAttribute("film") Film film) {
		return "add-film";
	}
	
	@PostMapping(path = "/add-film")
	public String ajoutFilm (@ModelAttribute("film") Film film) {
		
		this.service.addFilm(film);
		
		return "redirect:/home";
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

