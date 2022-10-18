package com.gft.gerenciareventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciareventos.entities.Administrador;
import com.gft.gerenciareventos.repositories.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;

	public Administrador salvarAdministrador(Administrador administrador) {
		return administradorRepository.save(administrador);
	}

	public List<Administrador> listarTodosOsAdministradores() {
		return administradorRepository.findAll();
	}

	public Administrador editarAdministrador(Long id) {
		Optional<Administrador> administrador = administradorRepository.findById(id);
		return administrador.get();
	}

	public void excluirAdministrador(Long id) {
		administradorRepository.deleteById(id);
	}
}
