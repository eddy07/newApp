package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.Client;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Client.class)
public interface ClientRepository {
}
