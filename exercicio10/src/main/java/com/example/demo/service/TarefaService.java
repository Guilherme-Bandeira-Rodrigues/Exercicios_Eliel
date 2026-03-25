package com.example.demo.service;

import com.example.demo.entity.Tarefa;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public Tarefa criarTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	public List<Tarefa> listarTarefas() {
		return tarefaRepository.findAll();
	}

	public Optional<Tarefa> buscarTarefaPorId(Long id) {
		return tarefaRepository.findById(id);
	}

	public void deletarTarefa(Long id) {
		tarefaRepository.deleteById(id);
	}
}