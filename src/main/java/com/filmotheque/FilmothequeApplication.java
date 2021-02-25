package com.filmotheque;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.filmotheque.model.Film;
import com.filmotheque.model.Genre;
import com.filmotheque.model.Membre;
import com.filmotheque.model.Participant;
import com.filmotheque.repository.FilmRepository;
import com.filmotheque.repository.GenreRepository;
import com.filmotheque.repository.MembreRepository;
import com.filmotheque.repository.ParticipantRepository;

@SpringBootApplication
public class FilmothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmothequeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FilmRepository filmRepository, ParticipantRepository participantRepository,
			GenreRepository genreRepository, MembreRepository membreRepository) {
		return (args) -> {
			Participant real = new Participant("real_nom", "réal_prenom");
			real = participantRepository.save(real);

			Genre g1 = new Genre("horreur");
			g1 = genreRepository.save(g1);

			Genre g2 = new Genre("comique");
			g2 = genreRepository.save(g2);

			Film f1 = new Film("titre1", 2000, 360,
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tortor eros, fringilla in nunc in, condimentum vehicula turpis. In sed sollicitudin tortor. Aenean finibus gravida ornare. Maecenas sed tristique nunc. Quisque finibus euismod urna. Vestibulum tincidunt, massa in ultricies vulputate, est erat bibendum tortor, a pulvinar magna eros non orci.");
			f1.setRealisateur(real);
			f1.setGenre(g1);

			Film f2 = new Film("titre2", 2010, 120,
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tortor eros, fringilla in nunc in, condimentum vehicula turpis. In sed sollicitudin tortor. Aenean finibus gravida ornare. Maecenas sed tristique nunc. Quisque finibus euismod urna. Vestibulum tincidunt, massa in ultricies vulputate, est erat bibendum tortor, a pulvinar magna eros non orci.");
			f2.setRealisateur(real);
			f2.setGenre(g2);

			filmRepository.save(f1);
			filmRepository.save(f2);
			
			
			Membre membre = new Membre();
			membre.setUsername("user");
			membre.setPassword(new BCryptPasswordEncoder().encode("user"));
			
			membreRepository.save(membre);
			
			Membre test = new Membre();
			test.setUsername("test");
			test.setPassword(new BCryptPasswordEncoder().encode("test"));
			
			membreRepository.save(test);

		};
	}
}
