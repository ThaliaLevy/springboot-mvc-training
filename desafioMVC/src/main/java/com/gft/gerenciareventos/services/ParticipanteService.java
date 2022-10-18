package com.gft.gerenciareventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciareventos.entities.Participante;
import com.gft.gerenciareventos.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;

	public Participante salvarParticipante(Participante participante) {
		return participanteRepository.save(participante);
	}

	public List<Participante> listarTodosOsParticipantes() {
		return participanteRepository.findAll();
	}

	public Participante editarParticipante(Long id) {
		Optional<Participante> participante = participanteRepository.findById(id);
		return participante.get();
	}

	public void excluirParticipante(Long id) {
		participanteRepository.deleteById(id);
	}
}
