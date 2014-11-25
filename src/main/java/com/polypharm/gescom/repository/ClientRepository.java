package com.polypharm.gescom.repository;
import java.util.List;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import com.polypharm.gescom.domain.Client;

@RooJpaRepository(domainType = Client.class)
public interface ClientRepository {
	
	public List<Client> findByNom(String nom);
	
	public List<Client> findByCode(String Code);
}
