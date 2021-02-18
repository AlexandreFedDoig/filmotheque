package com.filmotheque.model;

public class Genre {

	private long id;

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
	public Genre(long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
