package com.example.demo.controller;

import com.example.demo.entity.Tarefa;
import com.example.demo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping
	public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
		Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
		return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Tarefa> listarTarefas() {
		return tarefaService.listarTarefas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
		Optional<Tarefa> tarefa = tarefaService.buscarTarefaPorId(id);
		return tarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
		tarefaService.deletarTarefa(id);
		return ResponseEntity.noContent().build();
	}
}