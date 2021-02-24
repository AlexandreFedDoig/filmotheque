package com.filmotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmotheque.model.Avis;

public interface AvisRepository extends JpaRepository<Avis, Long> {

}
