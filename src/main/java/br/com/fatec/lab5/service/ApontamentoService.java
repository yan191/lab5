package br.com.fatec.lab5.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.lab5.model.Apontamento;
import br.com.fatec.lab5.repository.ApontamentoRepository;

@Service
public class ApontamentoService {
	
	@Autowired
	private ApontamentoRepository apontamentoRepository;
	
	@Transactional
	public Apontamento save(Apontamento ap) {
		Apontamento apontamento = new Apontamento();
		apontamento.setHoras(ap.getHoras());
		apontamento.setProjeto(ap.getProjeto());
		apontamentoRepository.save(apontamento);
		return apontamento;
	}

}
