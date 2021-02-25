package com.filmotheque.service;

import com.filmotheque.model.Membre;

public interface MembreService {
	
	Membre findByUsername(String username);
	
}
