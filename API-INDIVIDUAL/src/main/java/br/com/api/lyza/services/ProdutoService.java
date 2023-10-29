package br.com.api.lyza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.lyza.dto.ProdutoAtualizarDTO;
import br.com.api.lyza.dto.ProdutoDTO;
import br.com.api.lyza.entities.Pedido;
import br.com.api.lyza.entities.Produto;
import br.com.api.lyza.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	VendedorService vendedorService;

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	UserService userService;

	// GET id	
	public ProdutoDTO buscarPorId(Integer id) {
		ProdutoDTO infoProduto = new ProdutoDTO();
		Produto produto = produtoRepository.findById(id).get();
		infoProduto = converterProdutoDTO(produto);
		return infoProduto;
	}

	public List<Produto> buscarPorIdLista(Integer id) {
		List<Produto> listaProdutos = listarTodosA();
		
		for (Produto p : listaProdutos) {
			listaProdutos.add(p);
		}
		 
		return listaProdutos;
	}

	public List<ProdutoDTO> listarTodos() {
		List<ProdutoDTO> infoProdutos = new ArrayList<>();
		List<Produto> produtos = produtoRepository.findAll();
		for (Produto produto : produtos) {
			infoProdutos.add(converterProdutoDTO(produto));
		}
		return infoProdutos;
	}
	
	public List<Produto> listarTodosA() {
		return produtoRepository.findAll();
	}

	public Integer buscarIdPorObjeto(Pedido pedido) {
		Produto p = produtoRepository.findById(pedido.getId()).get();

		return p.getId();
	}

	public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
		Produto salvarProduto = new Produto();
		salvarProduto.setNome(produtoDTO.getNome());
		salvarProduto.setDescricao(produtoDTO.getDescricao());
		salvarProduto.setDataFab(produtoDTO.getDataFab());
		salvarProduto.setQtdEstoque(produtoDTO.getQtdEstoque());
		salvarProduto.setValorUnit(produtoDTO.getValorUnit());
		salvarProduto.setCategoria(categoriaService.buscarPorNome(produtoDTO.getCategoriaDTO()));
		salvarProduto.setVendedor(userService.buscarPorNomeCompleto(produtoDTO.getVendedorDTO2()));

		ProdutoDTO categoriaConvertida = converterProdutoDTO(salvarProduto);
		produtoRepository.save(salvarProduto);

		return categoriaConvertida;
	}

	public ProdutoAtualizarDTO atualizar(Integer id, ProdutoAtualizarDTO produtoAtualizarDTO) {
		Produto registroAntigo = produtoRepository.findById(id).get();

		if (produtoAtualizarDTO.getDescricao() != null) {
			registroAntigo.setDescricao(produtoAtualizarDTO.getDescricao());
		}
		if (produtoAtualizarDTO.getQtdEstoque() != null) {
			registroAntigo.setQtdEstoque(produtoAtualizarDTO.getQtdEstoque());
		}
		if (produtoAtualizarDTO.getValorUnit() != null) {
			registroAntigo.setValorUnit(produtoAtualizarDTO.getValorUnit());
		}
		if (produtoAtualizarDTO.getNome() != null) {
			registroAntigo.setNome(produtoAtualizarDTO.getNome());
		}
		ProdutoAtualizarDTO produtoConvertido = converterProdutoAtualizarDTO(registroAntigo);
		registroAntigo.setId(id);
		produtoRepository.save(registroAntigo);
		return produtoConvertido;
	}

	public ProdutoAtualizarDTO converterProdutoAtualizarDTO(Produto produto) {
		ProdutoAtualizarDTO produtoConvertido = new ProdutoAtualizarDTO();
		produtoConvertido.setNome(produto.getNome());
		produtoConvertido.setDescricao(produto.getDescricao());
		produtoConvertido.setQtdEstoque(produto.getQtdEstoque());
		produtoConvertido.setValorUnit(produto.getValorUnit());
		produtoConvertido.setFuncionarioDTO(vendedorService.buscarPorId(produto.getVendedor().getId()));
		produtoConvertido.setCategoriaDTO(categoriaService.buscarPorId(produto.getCategoria().getId()));
		return produtoConvertido;
	}

	public void removerLogico(Integer id) {
		Produto produto = produtoRepository.findById(id).get();

		if (produto != null) {
			produto.setAtivo(false);
			produtoRepository.save(produto);
		}
	}
	
	public ProdutoDTO converterProdutoDTO(Produto produto) {
		ProdutoDTO produtoConvertido = new ProdutoDTO();
		produtoConvertido.setNome(produto.getNome());
		produtoConvertido.setDescricao(produto.getDescricao());
		produtoConvertido.setDataFab(produto.getDataFab());
		produtoConvertido.setQtdEstoque(produto.getQtdEstoque());
		produtoConvertido.setValorUnit(produto.getValorUnit());
		produtoConvertido.setCategoriaDTO(categoriaService.buscarPorId(produto.getCategoria().getId()));
		produtoConvertido
				.setVendedorDTO2(vendedorService.buscarVendPorId(produto.getVendedor().getId()));
		return produtoConvertido;
	}
}
