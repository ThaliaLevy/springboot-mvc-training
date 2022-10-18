package com.gft.gerenciareventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciareventos.entities.Atividade;
import com.gft.gerenciareventos.repositories.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;

	public Atividade salvarAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}

	public List<Atividade> listarTodasAsAtividades() {
		return atividadeRepository.findAll();
	}

	public Atividade editarAtividade(Long id) {
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		return atividade.get();
	}

	public void excluirAtividade(Long id) {
		atividadeRepository.deleteById(id);
	}
}
