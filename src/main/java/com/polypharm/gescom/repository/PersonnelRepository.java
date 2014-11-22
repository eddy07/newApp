package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.Personnel;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Personnel.class)
public interface PersonnelRepository {
}
