package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.Installation;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Installation.class)
public interface InstallationRepository {
}
