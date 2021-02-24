package com.filmotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmotheque.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
