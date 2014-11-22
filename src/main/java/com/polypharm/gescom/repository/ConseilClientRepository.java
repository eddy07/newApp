package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.ConseilClient;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = ConseilClient.class)
public interface ConseilClientRepository {
}
