package com.polypharm.gescom.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.polypharm.gescom.domain.Personnel;

@RooService(domainTypes = { com.polypharm.gescom.domain.Personnel.class })
public interface PersonnelService {
	public List<Personnel> findByNomConnection(String nomConnection);
	public List<Personnel> findByEmail(String email);
}
