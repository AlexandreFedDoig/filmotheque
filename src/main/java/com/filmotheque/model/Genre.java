package com.filmotheque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String label;

	/**
	 * 
	 */
	public Genre() {
		super();
	}

	/**
	 * @param label
	 */
	public Genre(String label) {
		super();
		this.label = label;
	}

	/**
	 * @param id
	 * @param label
	 */
	public Genre(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
