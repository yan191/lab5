package br.com.fatec.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.lab5.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

}
