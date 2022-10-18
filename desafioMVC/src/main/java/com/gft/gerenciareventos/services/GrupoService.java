package com.gft.gerenciareventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciareventos.entities.Grupo;
import com.gft.gerenciareventos.repositories.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;

	public Grupo salvarGrupo(Grupo grupo) {
		return grupoRepository.save(grupo);
	}

	public List<Grupo> listarTodosOsGrupos() {
		return grupoRepository.findAll();
	}

	public Grupo editarGrupo(Long id) {
		Optional<Grupo> grupo = grupoRepository.findById(id);
		return grupo.get();
	}

	public void excluirGrupo(Long id) {
		grupoRepository.deleteById(id);
	}
}
