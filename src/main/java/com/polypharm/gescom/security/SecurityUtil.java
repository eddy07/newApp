package com.polypharm.gescom.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.Personnel;
import com.polypharm.gescom.service.PersonnelService;

@Service("securityUtil")
public class SecurityUtil implements Security {

	@Autowired
	PersonnelService personnelService;

	public  UserDetails getUserDetails() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null)
			return null;
		Authentication authentication = context.getAuthentication();
		if (authentication == null)
			return null;
		Object principal = authentication.getPrincipal();
		if (principal == null)
			return null;
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return null;
		}
	}

	public  String getUserName() {
		UserDetails userDetails = getUserDetails();
		if (userDetails != null)
			return userDetails.getUsername();
		return null;
	}

	public Personnel getPersonnel() {
		UserDetails userDetails = getUserDetails();
		if (userDetails == null)
			return null;
		String username = userDetails.getUsername();
		List<Personnel> resultList = personnelService.findByNomConnection(username);
		if (resultList != null && resultList.size() > 0) {

			return resultList.get(0);
		} else {//maybe it is an email
			List<Personnel> resultList1 = personnelService.findByEmail(username);
			if(resultList.isEmpty()){
				return null;
			}
			return resultList1.get(0);
		}
	}
	public boolean isUserLogged(){
		return getUserDetails() != null ;
	}
}
