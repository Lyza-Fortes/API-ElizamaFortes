package br.com.api.lyza.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.lyza.dto.PedidoDTO;
import br.com.api.lyza.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping("/salvar/{idCliente}")
	public ResponseEntity<?> salvar(@PathVariable Integer idCliente, @Valid @RequestBody PedidoDTO pedidoDTO) {
		return pedidoService.salvar(idCliente, pedidoDTO);
	}
	
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Integer id) {
		pedidoService.remover(id);
	}
	
}
