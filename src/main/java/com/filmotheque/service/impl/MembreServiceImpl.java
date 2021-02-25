package com.filmotheque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmotheque.model.Membre;
import com.filmotheque.repository.MembreRepository;
import com.filmotheque.service.MembreService;

@Service
public class MembreServiceImpl implements MembreService {
 
	@Autowired
	private MembreRepository membreRepository;
 
	@Override
	public Membre findByUsername(String username) {
		Membre user = null;
		try {
			user = membreRepository.findUserByUsername(username);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}
 
}