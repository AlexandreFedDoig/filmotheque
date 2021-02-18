package com.filmotheque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film {

	private long id;

	private String titre;

	private int annee;

	/**
	 * en minutes
	 */
	private int duree;

	private String synopsis;

	private Participant realisateur;

	private List<Participant> acteurs;

	private List<Avis> avis;

	private Genre genre;

	public Film() {
		this.acteurs = new ArrayList<>();
		this.avis = new ArrayList<>();
	}

	/**
	 * @param titre
	 * @param annee
	 * @param duree
	 * @param sysnopsis
	 */
	public Film(String titre, int annee, int duree, String synopsis) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.acteurs = new ArrayList<>();
		this.avis = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Participant getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Participant realisateur) {
		this.realisateur = realisateur;
	}

	public List<Participant> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Participant> acteurs) {
		this.acteurs = acteurs;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
