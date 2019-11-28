package br.com.fatec.lab5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="projeto")
public class Projeto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotNull
	@Size(max=100)
	private String nome;
	
	@NotNull
	private Integer horas_planejadas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHoras_planejadas() {
		return horas_planejadas;
	}

	public void setHoras_planejadas(Integer horas_planejadas) {
		this.horas_planejadas = horas_planejadas;
	}

}
