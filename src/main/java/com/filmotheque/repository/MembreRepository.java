package com.filmotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmotheque.model.Membre;

public interface MembreRepository extends JpaRepository<Membre, Long> {

}
