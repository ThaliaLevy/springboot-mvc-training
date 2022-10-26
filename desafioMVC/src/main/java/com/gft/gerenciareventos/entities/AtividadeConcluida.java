package com.gft.gerenciareventos.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AtividadeConcluida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private List<Evento> eventos;

	private boolean atividadeEntregue;

	private boolean entregaAtrasada;

	private Long participanteQueConcluiu;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public boolean isAtividadeEntregue() {
		return atividadeEntregue;
	}

	public void setAtividadeEntregue(boolean atividadeEntregue) {
		this.atividadeEntregue = atividadeEntregue;
	}

	public boolean isEntregaAtrasada() {
		return entregaAtrasada;
	}

	public void setEntregaAtrasada(boolean entregaAtrasada) {
		this.entregaAtrasada = entregaAtrasada;
	}

	public Long getParticipanteQueConcluiu() {
		return participanteQueConcluiu;
	}

	public void setParticipanteQueConcluiu(Long participanteQueConcluiu) {
		this.participanteQueConcluiu = participanteQueConcluiu;
	}
}
