package br.com.fatec.lab5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.lab5.model.Apontamento;

public interface ApontamentoRepository extends JpaRepository<Apontamento, Integer> {
	
	List<Apontamento> findByProjetoId(Integer projetoId );
	
}
