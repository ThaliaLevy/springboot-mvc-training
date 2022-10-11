package com.gft.projetos.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Desenvolvedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String quatroLetras;
	private String email;
	private BigDecimal salarioMensal;
	
	@ManyToOne
	private Linguagem linguagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuatroLetras() {
		return quatroLetras;
	}

	public void setQuatroLetras(String quatroLetras) {
		this.quatroLetras = quatroLetras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(BigDecimal salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public Linguagem getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(Linguagem linguagem) {
		this.linguagem = linguagem;
	}
}
