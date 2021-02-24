package com.filmotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmotheque.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
