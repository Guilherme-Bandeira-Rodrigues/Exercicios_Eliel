package com.example.demo.service;

import com.example.demo.entity.Projeto;
import com.example.demo.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	public Projeto criarProjeto(Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	public List<Projeto> listarProjetos() {
		return projetoRepository.findAll();
	}

	public Optional<Projeto> buscarProjetoPorId(Long id) {
		return projetoRepository.findById(id);
	}

	public void deletarProjeto(Long id) {
		projetoRepository.deleteById(id);
	}
}