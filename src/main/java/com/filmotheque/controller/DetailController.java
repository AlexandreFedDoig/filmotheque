package com.filmotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filmotheque.model.Film;
import com.filmotheque.service.DetailService;

@Controller
public class DetailController {

	private DetailService service;

	@Autowired
	public DetailController(DetailService service) {
		this.service = service;
	}

	@RequestMapping(path = "/detail")
	public String detail(Model model) {

		Film f = this.service.getFilm(0);

		model.addAttribute("film", f);

		return "detail";
	}

}
