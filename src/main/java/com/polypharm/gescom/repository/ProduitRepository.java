package com.polypharm.gescom.repository;
import java.util.List;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import com.polypharm.gescom.domain.Produit;

@RooJpaRepository(domainType = Produit.class)
public interface ProduitRepository {
	
	public List<Produit> findByNom(String nom);
	
	public List<Produit> findByCode(String Code);
}
