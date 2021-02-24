package com.filmotheque.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filmotheque.model.Avis;
import com.filmotheque.model.Film;
import com.filmotheque.model.Genre;
import com.filmotheque.model.Participant;
import com.filmotheque.repository.AvisRepository;
import com.filmotheque.repository.FilmRepository;
import com.filmotheque.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	private FilmRepository filmRepository;
	
	private AvisRepository avisRepository;
	
	
	/**
	 * @param filmRepository
	 * @param avisRepository
	 */
	public FilmServiceImpl(FilmRepository filmRepository, AvisRepository avisRepository) {
		this.filmRepository = filmRepository;
		this.avisRepository = avisRepository;
	}



	@Override
	public Film getFilm(long id) {
		return this.filmRepository.findById(id).get();
	}

	@Override
	public void addAvis(Avis avis, long idFilm) {
		Film f = this.getFilm(idFilm);
		avis = this.avisRepository.save(avis);
		f.getAvis().add(avis);
		filmRepository.save(f);
		
	}
	
	@Override
	public List<Film> getAllFilm(){
		return this.filmRepository.findAll();
	}
	
	@Override
	public void addFilm(Film film) {
		this.filmRepository.save(film);
	}

}
