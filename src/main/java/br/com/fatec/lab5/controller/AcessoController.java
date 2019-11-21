package br.com.fatec.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.lab5.security.User;
import br.com.fatec.lab5.service.UserService;

@RestController
public class AcessoController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> createNewUser(@RequestBody User usuario){
		User user;
		try {			
			user = userService.save(usuario);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
		user.setPassword("");
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/user")
	public ResponseEntity<User> getUserByUsername(@RequestParam("username") String username){
		User user;
		try {
			user = userService.getByUsername(username);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
		user.setPassword("");
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/teste")
	public ResponseEntity<String> getTeste() {
		return ResponseEntity.ok().body("Rota de admin");
	}

}
