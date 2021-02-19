package com.filmotheque.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filmotheque.model.Avis;
import com.filmotheque.model.Film;
import com.filmotheque.model.Genre;
import com.filmotheque.model.Participant;
import com.filmotheque.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService {

	private Film film;
	
	public DetailServiceImpl() {
		Film f = new Film("menfou", 2020, 120,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id malesuada ex, suscipit pulvinar nisl. Maecenas fermentum eget elit quis viverra. Sed vel ultrices enim. Mauris dapibus tellus magna, et euismod lorem laoreet eu. Vivamus vel libero dignissim, finibus libero vitae, blandit tellus. Nulla ac erat mattis, ullamcorper odio et, mollis nisi. Donec sed facilisis dolor. Aliquam tincidunt aliquam dui, eu aliquam orci ornare nec. Sed tincidunt vehicula augue nec vehicula. Donec iaculis nisi egestas elit ultrices condimentum. Suspendisse non ex at arcu iaculis tempor eu vel lacus. Etiam imperdiet sed arcu eget congue. Ut ornare urna eros, ac imperdiet.");
		f.setRealisateur(new Participant("real_nom", "real_prenom"));

		List<Participant> list = new ArrayList<>();
		list.add(new Participant("acteur1_nom", "acteur1_prenom"));
		list.add(new Participant("acteur2_nom", "acteur2_prenom"));
		f.setActeurs(list);

		f.setGenre(new Genre("horreur"));
		
		List<Avis> avis = new ArrayList<>();
		avis.add(new Avis(3, "ok"));
		avis.add(new Avis(0, "nul"));
		avis.add(new Avis(5, "super"));
		f.setAvis(avis);
		
		this.film = f;
	}
	
	@Override
	public Film getFilm(long id) {
		return this.film;
	}

	@Override
	public void addAvis(Avis avis, long idFilm) {
		this.film.getAvis().add(avis);
		
	}

}
