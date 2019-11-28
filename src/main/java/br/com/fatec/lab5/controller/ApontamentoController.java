package br.com.fatec.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.lab5.model.Apontamento;
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

}
