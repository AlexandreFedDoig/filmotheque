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

	private List<Film> films;
	
	public DetailServiceImpl() {
		this.films = new ArrayList<>();
		
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
		
		this.films.add(f);
	}
	
	@Override
	public Film getFilm(long id) {
		return this.films.get((int) id);
	}

	@Override
	public void addAvis(Avis avis, long idFilm) {
		this.films.get((int) idFilm).getAvis().add(avis);
		
	}
	
	@Override
	public List<Film> getAllFilm(){
		List<Film> films = new ArrayList<>();
		
		Film film1 = new Film("Film 1", 2020, 115, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		film1.setGenre(new Genre("Horreur"));
		film1.setRealisateur(new Participant("Albert", "Dupond"));
		films.add(film1);

		Film film2 = new Film("Film 2", 2016, 109, "Morbi id malesuada ex, suscipit pulvinar nisl.");
		film2.setGenre(new Genre("Action"));
		film2.setRealisateur(new Participant("Frederic", "Jones"));
		films.add(film2);
		
		Film film3 = new Film("Film 3", 2019, 116, "Maecenas fermentum eget elit quis viverra. Sed vel ultrices enim.");
		film3.setGenre(new Genre("Thriller"));
		film3.setRealisateur(new Participant("Jack", "O'Lantern"));
		films.add(film3);
		
		return films;
	}
	
	@Override
	public void addFilm(Film film) {
		this.addFilm(film);
	}

}
