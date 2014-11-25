package com.polypharm.gescom.repository;
import java.util.List;

import com.polypharm.gescom.domain.Personnel;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Personnel.class)
public interface PersonnelRepository {
	public List<Personnel> findByNomConnection(String nomConnection);
	public List<Personnel> findByEmail(String email);
}
