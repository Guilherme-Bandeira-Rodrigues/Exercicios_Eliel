package com.example.demo.controller;

import com.example.demo.entity.Projeto;
import com.example.demo.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@PostMapping
	public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
		Projeto novoProjeto = projetoService.criarProjeto(projeto);
		return new ResponseEntity<>(novoProjeto, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Projeto> listarProjetos() {
		return projetoService.listarProjetos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Projeto> buscarProjetoPorId(@PathVariable Long id) {
		Optional<Projeto> projeto = projetoService.buscarProjetoPorId(id);
		return projeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
		projetoService.deletarProjeto(id);
		return ResponseEntity.noContent().build();
	}
}