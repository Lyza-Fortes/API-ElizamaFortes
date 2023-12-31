package br.com.api.lyza.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.lyza.dto.ClienteDTO;
import br.com.api.lyza.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/buscar/{id}")
	public ClienteDTO buscarPorId(@PathVariable Integer id) {
		return clienteService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<ClienteDTO> listarTodos() {
		return clienteService.listarTodos();
	}
	
	@PutMapping("/atualizar/{id}")
	public ClienteDTO atualizar(@PathVariable Integer id, @Valid @RequestBody ClienteDTO cliente) {
		return clienteService.atualizar(id, cliente);
	}
	
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Integer id) {
		clienteService.remover(id);
	}
	

}
