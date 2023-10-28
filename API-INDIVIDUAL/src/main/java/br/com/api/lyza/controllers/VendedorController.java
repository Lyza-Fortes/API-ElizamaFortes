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

import br.com.api.lyza.dto.VendedorDTO;
import br.com.api.lyza.services.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	VendedorService vendedorService;
	
	@GetMapping("/buscar/{id}")
	public VendedorDTO buscarPorId(@PathVariable Integer id) {
		return vendedorService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<VendedorDTO> listarTodos() {
		return vendedorService.listarTodos();
	}
	
	@PutMapping("/atualizar/{id}")
	public VendedorDTO atualizar(@PathVariable Integer id, @Valid @RequestBody VendedorDTO vendedor) {
		return vendedorService.atualizar(id, vendedor);
	}
	
	@PutMapping("/ativar/{id}")
	public void ativarLogico(@PathVariable Integer id) {
		vendedorService.ativarLogico(id);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
		vendedorService.removerLogico(id);
	}
	
}
