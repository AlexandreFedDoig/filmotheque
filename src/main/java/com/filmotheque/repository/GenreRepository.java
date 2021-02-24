package com.filmotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmotheque.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
