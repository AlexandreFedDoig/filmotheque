package com.filmotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filmotheque.model.Film;
import com.filmotheque.service.FilmService;

@Controller
public class AccueilController {

	private FilmService service;
	
	@Autowired
	public AccueilController(FilmService service) {
		this.service = service;
	}


	@RequestMapping(path = "/home")
	public String home(Model model) {

		List<Film> films = this.service.getAllFilm();

		model.addAttribute("films", films);

		return "home";
	}

	@GetMapping(path = "/add-film")
	public String formulaireFilm(@ModelAttribute("film") Film film) {
		return "add-film";
	}

	@PostMapping(path = "/add-film")
	public String ajoutFilm(@ModelAttribute("film") Film film) {

		this.service.addFilm(film);

		return "redirect:/home";
	}
}
