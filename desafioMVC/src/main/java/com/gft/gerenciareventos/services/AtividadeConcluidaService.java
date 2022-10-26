package com.gft.gerenciareventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciareventos.entities.AtividadeConcluida;
import com.gft.gerenciareventos.repositories.AtividadeConcluidaRepository;

@Service
public class AtividadeConcluidaService {

	@Autowired
	private AtividadeConcluidaRepository atividadeConcluidaRepository;
	
	public AtividadeConcluida salvarAtividade(AtividadeConcluida atividadeConcluida) {
		return atividadeConcluidaRepository.save(atividadeConcluida);
	}
	
	public AtividadeConcluida listarAtividadeConcluida(Long id) {
		Optional<AtividadeConcluida> atividadeConcluida = atividadeConcluidaRepository.findById(id);
		return atividadeConcluida.get();
	}
}
