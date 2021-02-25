package com.filmotheque.controller;

import java.util.ArrayList;
import java.util.List;

import com.filmotheque.controller.modelForm.FilmForm;
import com.filmotheque.model.Genre;
import com.filmotheque.model.Participant;
import org.springframework.beans.BeanUtils;
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
	public String formulaireFilm(Model model) {
		List<Participant> listePartipants = service.getAllParticipants();
		List<Genre> listeGenres = service.getAllGenres();

		model.addAttribute("filmForm", new FilmForm());
		model.addAttribute("listePartipants", listePartipants);
		model.addAttribute("listeGenres", listeGenres);

		return "add-film";
	}

	@PostMapping(path = "/add-film")
	public String ajoutFilm(@ModelAttribute("filmForm") FilmForm filmForm) {
		System.out.println("Debug -------- Entrée Controller");
		Film film = new Film();
		BeanUtils.copyProperties(filmForm, film);

		service.addFilm(film);
		System.out.println("Debug -------- film = "+ film.toString());
		return "redirect:/home";
	}
}
