package com.example.demo.controller;

import com.example.demo.entity.Departamento;
import com.example.demo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@PostMapping
	public ResponseEntity<Departamento> criarDepartamento(@RequestBody Departamento departamento) {
		Departamento novoDepartamento = departamentoService.criarDepartamento(departamento);
		return new ResponseEntity<>(novoDepartamento, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Departamento> listarDepartamentos() {
		return departamentoService.listarDepartamentos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable Long id) {
		Optional<Departamento> departamento = departamentoService.buscarDepartamentoPorId(id);
		return departamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
		departamentoService.deletarDepartamento(id);
		return ResponseEntity.noContent().build();
	}
}