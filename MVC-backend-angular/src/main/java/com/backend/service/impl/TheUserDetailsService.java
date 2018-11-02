/**
 * 
 */
package com.backend.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.entities.User;
import com.backend.entities.UserRole;
import com.backend.repository.UserRepository;

/**
 * @author m.BOUABID
 *
 */
@Service
public class TheUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * retreive authenticate user by his Role to verify it later if he is autorized to access the API or Not
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User retreivedUser = userRepository.findByUserName(username);
		List<GrantedAuthority> authorities = this.createUserAuthorities(retreivedUser.getUserRole());
		return (UserDetails) this.buildUserForAuthentication(retreivedUser, authorities);
	}
	
	private User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		User usr = new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
		return usr;
	}
	
	/**
	 * give the user authority based on his Role in database, which gonna be converted by our method to SIMPLE.GRANTED.AUTHORITY
	 * to be processed later in Servlet intercepting and check authorities
	 * 
	 * One USER can have multiple authorities for that reason the return back a List<GrantedAuthority>.
	 * @param userRoles
	 * @return
	 */
	private List<GrantedAuthority> createUserAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> authsList = new HashSet<GrantedAuthority>();
		// create user's authorities
		userRoles.forEach(userRole -> {
			authsList.add(new SimpleGrantedAuthority(userRole.getRole()));
		});
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(authsList);
		return Result;
	}
}
