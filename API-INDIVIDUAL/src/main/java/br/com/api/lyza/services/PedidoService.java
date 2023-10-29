package br.com.api.lyza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.lyza.dto.PedidoDTO;
import br.com.api.lyza.entities.Cliente;
import br.com.api.lyza.entities.Pedido;
import br.com.api.lyza.entities.PedidoProduto;
import br.com.api.lyza.entities.Produto;
import br.com.api.lyza.repositories.ClienteRepository;
import br.com.api.lyza.repositories.PedidoRepository;
import br.com.api.lyza.repositories.ProdutoRepository;
import br.com.api.lyza.repositories.RoleRepository;
import br.com.api.lyza.repositories.UserRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ProdutoService produtoService;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClienteRepository clienteRepository;


	// POST
	public ResponseEntity<?> salvar(Integer idCliente, PedidoDTO pedidoDTO) throws NullPointerException {
		Pedido salvarPedido = new Pedido();
		PedidoProduto pedidoProduto = new PedidoProduto();
		Cliente cliente = clienteRepository.findById(idCliente).get();

		Double valor = 0.0;
		List<Produto> produtos = new ArrayList<>();
		for (Integer idProduto : pedidoDTO.getIdProdutos()) {
			Produto produto = produtoRepository.findById(idProduto).get();
			valor += pedidoDTO.getItemQuantidade() * produto.getValorUnit();
			pedidoProduto.setValorTotal(valor);
			pedidoProduto.setItemQuantidade(pedidoDTO.getItemQuantidade());
			produto.getItemQuantidade().put(salvarPedido, pedidoProduto);
			produto.setQtdEstoque(produto.getQtdEstoque()-pedidoDTO.getItemQuantidade());
			produtos.add(produto);
		}
		
		salvarPedido.setDataPedido(pedidoDTO.getDataPedido());
		pedidoRepository.save(salvarPedido);
		
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(salvarPedido);
		clienteRepository.save(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Pedido efetuado com sucesso!");
	}

	// DELETE
	public void remover(Integer id) {
		pedidoRepository.deleteById(id);
	}

}