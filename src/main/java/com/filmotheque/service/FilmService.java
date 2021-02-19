package com.filmotheque.service;


import java.util.List;

import com.filmotheque.model.Avis;

import com.filmotheque.model.Film;

public interface FilmService {
	

	public Film getFilm(long id);
	
	public List<Film> getAllFilm();
	
	void addFilm(Film film);

	void addAvis(Avis avis, long idFilm);
	

}
