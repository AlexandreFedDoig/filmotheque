package com.filmotheque.service;

import com.filmotheque.model.Avis;
import com.filmotheque.model.Film;

public interface DetailService {
	
	Film getFilm(long id);
	
	void addAvis(Avis avis, long idFilm);
	

}
