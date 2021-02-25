package com.filmotheque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titre;

	private int annee;

	/**
	 * en minutes
	 */
	private int duree;
	
	@Column(length = 500)
	private String synopsis;

	@ManyToOne
	private Participant realisateur;

	@ManyToMany()
	private List<Participant> acteurs;

	@ManyToMany()
	private List<Avis> avis;

	@ManyToOne
	private Genre genre;

	public Film() {
		this.acteurs = new ArrayList<>();
		this.avis = new ArrayList<>();
	}

	/**
	 * @param titre
	 * @param annee
	 * @param duree
	 * @param synopsis
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public String toString() {
		return "Film{" +
				"id=" + id +
				", titre='" + titre + '\'' +
				", annee=" + annee +
				", duree=" + duree +
				", synopsis='" + synopsis + '\'' +
				", realisateur=" + realisateur +
				", acteurs=" + acteurs +
				", avis=" + avis +
				", genre=" + genre +
				'}';
	}
}
