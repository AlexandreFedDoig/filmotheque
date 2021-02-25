package com.filmotheque.service;


import java.util.List;

import com.filmotheque.model.Avis;

import com.filmotheque.model.Film;
import com.filmotheque.model.Genre;
import com.filmotheque.model.Participant;

public interface FilmService {
	

	public Film getFilm(long id);
	
	public List<Film> getAllFilm();
	
	void addFilm(Film film);

	void addAvis(Avis avis, long idFilm);
	
	public List<Participant> getAllParticipants();

	public List<Genre> getAllGenres();
}
