package com.filmotheque.model;

public class Avis {

	private long id;

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
	public Avis(long id, int note, String label) {
		super();
		this.id = id;
		this.note = note;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
