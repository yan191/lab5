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

import br.com.fatec.lab5.model.Apontamento;
import br.com.fatec.lab5.model.Projeto;
import br.com.fatec.lab5.service.ApontamentoService;

@RestController
public class ApontamentoController {
	
	@Autowired
	ApontamentoService apontamentoService;
	
	@PostMapping("/apontamento")
	public ResponseEntity<Apontamento> createNewApontamento(@RequestBody ApontamentoForm apForm){
		Apontamento ap;
		try {			
			ap = apontamentoService.save(apForm);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok().body(ap);
	}
	
	@GetMapping("/apontamento/projeto/{projetoId}")
	public ResponseEntity<List<Apontamento>> findApontamentosByProjetoId(@PathVariable Integer projetoId){
		List<Apontamento> apontamentos = apontamentoService.findApontamentosByProjetoId(projetoId);
		return ResponseEntity.ok().body(apontamentos);
	}

}
