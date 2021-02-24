package com.filmotheque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int note;

	private String label;

	/**
	 * 
	 */
	public Avis() {
		super();
	}

	/**
	 * @param note
	 * @param label
	 */
	public Avis(int note, String label) {
		super();
		this.note = note;
		this.label = label;
	}

	/**
	 * @param id
	 * @param note
	 * @param label
	 */
	public Avis(Long id, int note, String label) {
		super();
		this.id = id;
		this.note = note;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
