package br.com.fatec.lab5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.lab5.model.Projeto;
import br.com.fatec.lab5.service.ProjetoService;

@RestController
public class ProjetoController {
	
	@Autowired
	ProjetoService projetoService;
	
	@PostMapping("/projeto")
	public ResponseEntity<Projeto> createNewProjeto(@RequestBody Projeto project){
		Projeto projeto;
		try {			
			projeto = projetoService.save(project);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok().body(projeto);
	}
	
	@GetMapping("/projeto")
	public ResponseEntity<List<Projeto>> findAllProjeto(){
		List<Projeto> projetos = projetoService.findAll();
		return ResponseEntity.ok().body(projetos);
	}
	
	@GetMapping("/projeto/{projetoId}")
	public ResponseEntity<Optional<Projeto>> findProjetoById(@PathVariable Integer projetoId){
		Optional<Projeto> projeto = projetoService.findById(projetoId);
		return ResponseEntity.ok().body(projeto);
	}
	
}
