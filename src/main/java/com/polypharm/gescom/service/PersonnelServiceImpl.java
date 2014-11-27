package com.polypharm.gescom.service;

import java.util.List;

import com.polypharm.gescom.domain.Personnel;

public class PersonnelServiceImpl implements PersonnelService {
	public List<Personnel> findByNomConnection(String nomConnection) {
		return personnelRepository.findByNomConnection(nomConnection);
	}
	
	public List<Personnel> findByEmail(String email){
		return personnelRepository.findByEmail(email);
	}
}
