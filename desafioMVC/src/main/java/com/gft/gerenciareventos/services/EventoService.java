package com.gft.gerenciareventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciareventos.entities.Evento;
import com.gft.gerenciareventos.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	public Evento salvarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	public List<Evento> listarTodosOsEventos() {
		return eventoRepository.findAll();
	}

	public Evento editarEvento(Long id) {
		Optional<Evento> evento = eventoRepository.findById(id);
		return evento.get();
	}

	public void excluirEvento(Long id) {
		eventoRepository.deleteById(id);
	}
}
