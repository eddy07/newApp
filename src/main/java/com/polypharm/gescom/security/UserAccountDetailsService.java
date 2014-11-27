package com.polypharm.gescom.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polypharm.gescom.domain.Personnel;
import com.polypharm.gescom.domain.RoleName;
import com.polypharm.gescom.service.PersonnelService;

@Service
@Transactional
public class UserAccountDetailsService implements UserDetailsService {

	@Autowired
	PersonnelService personnelService;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		try {

			if (StringUtils.isBlank(username)) {
				throw new UsernameNotFoundException(
						"user not found");
			}
			List<Personnel> resultList = personnelService.findByNomConnection(username);
			if(resultList!=null && resultList.size()>0){
				Personnel personnel = null;
				for (Personnel found : resultList) {
					personnel = found;
				}
				if (personnel == null)
					throw new UsernameNotFoundException(
							"user not found");
				return createUserDetails(personnel);
			}else{
				List<Personnel> resultList1 = personnelService.findByEmail(username);
				
				Personnel personnel = null;
					for (Personnel found : resultList1) {
						personnel = found;
					}
					if (personnel == null)
						throw new UsernameNotFoundException(
								"user not found");
					return createUserDetails(personnel);
			}
		} finally {

		}
	}

	public static UserDetails createUserDetails(Personnel user)
			throws UsernameNotFoundException, DataAccessException {
		String password = user.getMotDePass();
		boolean enabled = !user.getDisableLogin();
		Date accountExpiration = user.getAccountExpiration();
		boolean accountNonExpired = false;
		if (accountExpiration != null) {
			accountNonExpired = new Date().before(accountExpiration);
		}
		Date credentialExpiration = user.getCredentialExpiration();
		boolean credentialsNonExpired = false;
		if (credentialExpiration != null) {
			credentialsNonExpired = new Date().before(credentialExpiration);
		}
		boolean accountNonLocked = !user.getAccountLocked();

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		RoleName roleName = user.getRoleName();
		GrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName.name());
		authorities.add(simpleGrantedAuthority);
		UserDetails userDetails = new User(user.getNomConnection(), password,
				enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		return userDetails;
	}
}
