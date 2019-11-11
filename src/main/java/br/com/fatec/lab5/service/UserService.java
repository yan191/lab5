package br.com.fatec.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fatec.lab5.security.AuthorityRepository;
import br.com.fatec.lab5.security.User;
import br.com.fatec.lab5.security.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User usuario) {
		User user = new User();
		user.setUsername(usuario.getUsername());
	    user.setPassword(passwordEncoder.encode(usuario.getPassword()));
	    user.setAuthorities(authorityRepository.findAll());
	    user.setNomeCompleto(usuario.getNomeCompleto());
	    user.setEmail(usuario.getEmail());
	    userRepository.save(user);
	    return user;
	}
	
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
