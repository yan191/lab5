package br.com.fatec.lab5.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		List<GrantedAuthority> listGrantAuthority = checkGrantAuthorities(user, user.getAuthorities());
		UserDetails userDetails = validateUser(username, listGrantAuthority,user);
		return userDetails;
	}
	
	private UserDetails validateUser(String username,List<GrantedAuthority> listGrantAuthority, User user) {
		UserDetails userDetails= null;
		if(user!=null){
			boolean accountNonLocked=true;
			boolean enabledUser=true;
			boolean accountNonExpired=true;
			boolean credentialsNonExpired=true;
			userDetails = new  org.springframework.security.core.userdetails.User(username, user.getPassword(), enabledUser, accountNonExpired, credentialsNonExpired, accountNonLocked, listGrantAuthority);
		}	
		return userDetails;
	}
	
	private List<GrantedAuthority> checkGrantAuthorities(User user, List<Authority> authority) {
		List<GrantedAuthority> listGrantAuthority = new ArrayList<GrantedAuthority>();
		for(Authority roleUser : user.getAuthorities()){
			String role = roleUser.getAuthorityName();
			listGrantAuthority.add(new SimpleGrantedAuthority(role));	
		}
		return listGrantAuthority;
	}

}