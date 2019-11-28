package br.com.fatec.lab5.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.lab5.controller.ApontamentoForm;
import br.com.fatec.lab5.model.Apontamento;
import br.com.fatec.lab5.model.Projeto;
import br.com.fatec.lab5.repository.ApontamentoRepository;
import br.com.fatec.lab5.repository.ProjetoRepository;

@Service
public class ApontamentoService {
	
	@Autowired
	private ApontamentoRepository apontamentoRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Transactional
	public Apontamento save(ApontamentoForm ap) {
		Projeto projeto = projetoRepository.getOne(ap.getProjeto_id());
		
		Apontamento apontamento = new Apontamento();
		apontamento.setHoras(ap.getHoras());
		apontamento.setProjeto(projeto);
		apontamentoRepository.save(apontamento);
		return apontamento;
	}

}
