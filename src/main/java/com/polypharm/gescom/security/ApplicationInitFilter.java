package com.polypharm.gescom.security;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.polypharm.gescom.domain.Agence;
import com.polypharm.gescom.domain.Personnel;
import com.polypharm.gescom.domain.RoleName;
import com.polypharm.gescom.service.AgenceService;
import com.polypharm.gescom.service.PersonnelService;

/**
 * Used to initialize the application, creating the defaul user, aso.
 * 
 * @author guymoyo
 * @author bwa
 *
 */
@Service("applicationInitFilter")
public class ApplicationInitFilter extends OncePerRequestFilter {

	private boolean initialized;
	
	@Autowired
	PersonnelService personnelService;
	
	@Autowired
	AgenceService agenceService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (!initialized){
			
			HashSet<RoleName> set = new HashSet<RoleName>();
			set.add(RoleName.RESPONSABLE_INFORMATIQUE);
			Agence agence = new Agence("Direction Generale", "Polypharma Douala");
			agenceService.saveAgence(agence);
			Personnel personnel = new Personnel("Mamadou", "admin", "admin123", "Mamadou Ali", RoleName.RESPONSABLE_INFORMATIQUE, agence);
			personnelService.savePersonnel(personnel);
			/*String encodePassword = account.encodePassword("test123");
			account.setPassword(encodePassword);*/
			initialized = true;
		}

		filterChain.doFilter(request, response);
	}

}
