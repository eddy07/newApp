package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.Livraison;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Livraison.class)
public interface LivraisonRepository {
}
