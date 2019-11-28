package br.com.fatec.lab5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.lab5.model.Projeto;
import br.com.fatec.lab5.repository.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Transactional
	public Projeto save(Projeto project) {
		Projeto projeto = new Projeto();
		projeto.setNome(project.getNome());
		projeto.setHoras_planejadas(project.getHoras_planejadas());
		projetoRepository.save(projeto);
		return projeto;
	}
	
	public List<Projeto> findAll() {
		return projetoRepository.findAll();
	}
	
	public Optional<Projeto> findById(Integer id) {
		return projetoRepository.findById(id);
	}

}
