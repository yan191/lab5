package br.com.fatec.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.lab5.model.Apontamento;

public interface ApontamentoRepository extends JpaRepository<Apontamento, Integer> {
	
	Apontamento findByProjetoId(Integer projetoId );
	
}
