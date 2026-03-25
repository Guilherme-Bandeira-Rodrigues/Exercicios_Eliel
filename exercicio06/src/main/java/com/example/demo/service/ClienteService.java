package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente criarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> buscarClientePorId(Long id) {
		return clienteRepository.findById(id);
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}