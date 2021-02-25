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
			Participant real = new Participant("Spielberg", "Steven");
		    Participant acteur1 = new Participant("GOLDBLUM", "JEFF");
		    Participant acteur2 = new Participant("L.JACKSON", "SAMUEL");
		    real = participantRepository.save(real);
		    participantRepository.save(acteur1);
		    participantRepository.save(acteur2);

			Genre g1 = new Genre("action");
			g1 = genreRepository.save(g1);

			

			Film f1 = new Film("Jurassic Park", 1993, 120, "Ne pas réveiller le chat qui dort... C'est ce que le milliardaire John Hammond aurait dû se rappeler avant de se lancer dans le \"clonage\" de dinosaures. C'est à partir d'une goutte de sang absorbée par un moustique fossilisé que John Hammond et son équipe ont réussi à faire renaître une dizaine d'espèces de dinosaures. Il s'apprête maintenant avec la complicité du docteur Alan Grant, paléontologue de renom, et de son amie Ellie, à ouvrir le plus grand parc à thème du monde. Mais c'était sans compter la cupidité et la malveillance de l'informaticien Dennis Nedry, et éventuellement des dinosaures, seuls maîtres sur l'île...");
			f1.setRealisateur(real);
			f1.setGenre(g1);
			f1.getActeurs().add(acteur1);
			f1.getActeurs().add(acteur2);

			filmRepository.save(f1);
			
      
			Participant p1 = new Participant("NOLAN", "CHRISTOPHER");
		    Participant p2 = new Participant("Statham", "Jason");
		    Participant p3 = new Participant("DIESEL", "VIN");
		    Participant p4 = new Participant("JACKMAN", "HUGH");
			
		    Genre g2 = new Genre("comique");
			g2 = genreRepository.save(g2);
			
			participantRepository.save(p1);
			participantRepository.save(p2);
			participantRepository.save(p3);
			participantRepository.save(p4);
			
			
      
			
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
