package com.example.demo.service;

import com.example.demo.entity.Departamento;
import com.example.demo.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	public Departamento criarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public List<Departamento> listarDepartamentos() {
		return departamentoRepository.findAll();
	}

	public Optional<Departamento> buscarDepartamentoPorId(Long id) {
		return departamentoRepository.findById(id);
	}

	public void deletarDepartamento(Long id) {
		departamentoRepository.deleteById(id);
	}
}