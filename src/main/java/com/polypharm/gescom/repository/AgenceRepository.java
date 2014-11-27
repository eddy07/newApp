package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.Agence;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Agence.class)
public interface AgenceRepository {
}
