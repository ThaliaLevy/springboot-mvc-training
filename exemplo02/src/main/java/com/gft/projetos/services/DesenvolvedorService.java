package com.gft.projetos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.projetos.entities.Desenvolvedor;
import com.gft.projetos.repositories.DesenvolvedorRepository;

@Service
public class DesenvolvedorService {

	@Autowired
	private DesenvolvedorRepository desenvolvedorRepository;

	public Desenvolvedor salvarDesenvolvedor(Desenvolvedor desenvolvedor) {

		return desenvolvedorRepository.save(desenvolvedor);
	}

	public List<Desenvolvedor> listarDesenvolvedores(String nome, String quatroLetras) {
		if (nome != null || quatroLetras != null)
			return listarDesenvolvedorPorNomeEQuatroLetras(nome, quatroLetras);
		return listarTodosOsDesenvolvedores(); 
	}

	public List<Desenvolvedor> listarTodosOsDesenvolvedores() {
		return desenvolvedorRepository.findAll();
	}

	public List<Desenvolvedor> listarDesenvolvedorPorNomeEQuatroLetras(String nome, String quatroLetras) {
		return desenvolvedorRepository.findByNomeContainsAndQuatroLetrasContains(nome, quatroLetras);
	}

	public Desenvolvedor obterDesenvolvedor(Long id) throws Exception {
		Optional<Desenvolvedor> desenvolvedor = desenvolvedorRepository.findById(id);

		if (desenvolvedor.isEmpty()) {
			throw new Exception("Não há desenvolvedor.");
		}

		return desenvolvedor.get();
	}

	public void excluirDesenvolvedor(Long id) {
		desenvolvedorRepository.deleteById(id);
	}
}
