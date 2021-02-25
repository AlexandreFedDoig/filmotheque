package com.filmotheque.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.filmotheque.model.Membre;
import com.filmotheque.service.MembreService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
 
	@Autowired
	private MembreService membreService;
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		if (username.trim().isEmpty()) {
			throw new UsernameNotFoundException("username is empty");
		}
 
		Membre membre = membreService.findByUsername(username);
 
		if (membre == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}
		
		return new org.springframework.security.core.userdetails.User(membre.getUsername(), membre.getPassword(), getGrantedAuthorities());
	}
 
	private List<GrantedAuthority> getGrantedAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		return authorities;
	}
 
}