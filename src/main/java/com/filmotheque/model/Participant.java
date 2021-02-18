package com.filmotheque.model;

public class Participant {

	private long id;

	private String nom;

	private String prenom;

	/**
	 * 
	 */
	public Participant() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 */
	public Participant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public Participant(long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
