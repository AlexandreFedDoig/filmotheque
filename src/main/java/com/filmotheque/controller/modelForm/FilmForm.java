package com.filmotheque.controller.modelForm;

import com.filmotheque.model.Film;
import com.filmotheque.model.Genre;
import com.filmotheque.model.Participant;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class FilmForm {
    private Long id;

    private String titre;

    private String synopsis;

    private int annee;

    private int duree;

    private Long genre;

    private Long realisateur;

    private List<Long> acteurs;

    public FilmForm() {
    }

    public FilmForm(String titre, String synopsis, int annee, int duree, Long genre, Long realisateur, List<Long> acteurs) {
        this.titre = titre;
        this.synopsis = synopsis;
        this.annee = annee;
        this.duree = duree;
        this.genre = genre;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }

    public FilmForm(Long id, String titre, String synopsis, int annee, int duree, Long genre, Long realisateur, List<Long> acteurs) {
        this.id = id;
        this.titre = titre;
        this.synopsis = synopsis;
        this.annee = annee;
        this.duree = duree;
        this.genre = genre;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettitre() {
        return titre;
    }

    public void settitre(String titre) {
        this.titre = titre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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

    public Long getGenre() {
        return genre;
    }

    public void setGenre(Long genre) {
        this.genre = genre;
    }

    public Long getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Long realisateur) {
        this.realisateur = realisateur;
    }

    public List<Long> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Long> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "FilmForm{" +
                "titre='" + titre + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", genre=" + genre +
                ", realisateur=" + realisateur +
                ", acteurs=" + acteurs +
                '}';
    }

    public Film toModel (){
        Film film = new Film();

        film.setTitre(this.gettitre());
        film.setSynopsis(this.getSynopsis());
        film.setAnnee(this.getAnnee());
        film.setAnnee(this.getAnnee());

        Genre genre = new Genre();
        genre.setId(this.getGenre());
        film.setGenre(genre);

        Participant real = new Participant();
        real.setId(this.getRealisateur());
        film.setRealisateur(real);

        List<Participant> listeActeurs = new ArrayList<>();
        for (Long acteur: this.getActeurs()) {
            Participant participant = new Participant();
            participant.setId(acteur);
            listeActeurs.add(participant);
        }
        film.setActeurs(listeActeurs);

        return film;
    }
}
