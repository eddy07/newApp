package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.VeilleConcurrentielleProduit;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = VeilleConcurrentielleProduit.class)
public interface VeilleConcurentielleProduitRepository {
}
