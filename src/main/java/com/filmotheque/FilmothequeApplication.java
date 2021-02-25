package com.filmotheque;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.filmotheque.model.Film;
import com.filmotheque.model.Genre;
import com.filmotheque.model.Participant;
import com.filmotheque.repository.FilmRepository;
import com.filmotheque.repository.GenreRepository;
import com.filmotheque.repository.ParticipantRepository;

@SpringBootApplication
public class FilmothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmothequeApplication.class, args);
	}

	
	@Bean
	  public CommandLineRunner demo(FilmRepository filmRepository, ParticipantRepository participantRepository, GenreRepository genreRepository) {
	    return (args) -> {
	    Participant real = new Participant("real_nom", "réal_prenom");
	    Participant real2 = new Participant("Deux", "réal_prenom");
	    Participant real3 = new Participant("Trois", "réal_prenom");
	    real = participantRepository.save(real);
	    participantRepository.save(real2);
	    participantRepository.save(real3);

	    Genre g1 = new Genre("horreur");
	    g1 = genreRepository.save(g1);
	    
	    Genre g2 = new Genre("comique");
	    g2 = genreRepository.save(g2);
	    
	     Film f1 = new Film("titre1", 2000, 360, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tortor eros, fringilla in nunc in, condimentum vehicula turpis. In sed sollicitudin tortor. Aenean finibus gravida ornare. Maecenas sed tristique nunc. Quisque finibus euismod urna. Vestibulum tincidunt, massa in ultricies vulputate, est erat bibendum tortor, a pulvinar magna eros non orci.");
	     f1.setRealisateur(real);
	     f1.setGenre(g1);
	     
	     Film f2 = new Film("titre2", 2010, 120, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tortor eros, fringilla in nunc in, condimentum vehicula turpis. In sed sollicitudin tortor. Aenean finibus gravida ornare. Maecenas sed tristique nunc. Quisque finibus euismod urna. Vestibulum tincidunt, massa in ultricies vulputate, est erat bibendum tortor, a pulvinar magna eros non orci.");
	     f2.setRealisateur(real);
	     f2.setGenre(g2);
	     
	     filmRepository.save(f1);
	     filmRepository.save(f2);
	    };
	}
}

