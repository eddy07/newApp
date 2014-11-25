package com.polypharm.gescom.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.polypharm.gescom.domain.Personnel;

public interface Security {
	
	public UserDetails getUserDetails();
	
	public  String getUserName();
	
	public Personnel getPersonnel();

}
