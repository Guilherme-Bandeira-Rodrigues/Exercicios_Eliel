package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
		Cliente novoCliente = clienteService.criarCliente(cliente);
		return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
		return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
}