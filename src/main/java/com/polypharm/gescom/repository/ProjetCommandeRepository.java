package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.ProjetCommande;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = ProjetCommande.class)
public interface ProjetCommandeRepository {
}
