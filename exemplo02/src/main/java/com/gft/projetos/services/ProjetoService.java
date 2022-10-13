package com.gft.projetos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.projetos.entities.Projeto;
import com.gft.projetos.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	public Projeto salvarProjeto(Projeto projeto) {

		return projetoRepository.save(projeto);
	}

	public List<Projeto> listarProjetos() {
		return projetoRepository.findAll();
	}

	public Projeto obterProjeto(Long id) throws Exception {
		Optional<Projeto> projeto = projetoRepository.findById(id);

		if (projeto.isEmpty()) {
			throw new Exception("Não há projeto.");
		}

		return projeto.get();
	}

	public void excluirProjeto(Long id) {
		projetoRepository.deleteById(id);
	}
}
