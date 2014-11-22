package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.FamilleProduit;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = FamilleProduit.class)
public interface FamilleProduitRepository {
}
