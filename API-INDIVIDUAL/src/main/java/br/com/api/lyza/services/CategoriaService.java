package br.com.api.lyza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.lyza.dto.CategoriaDTO;
import br.com.api.lyza.entities.Categoria;
import br.com.api.lyza.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public CategoriaDTO buscarPorId(Integer id) {
		CategoriaDTO infoCategoria = new CategoriaDTO();
		Categoria categoria = categoriaRepository.findById(id).get();
		infoCategoria = converterCategoriaDTO(categoria);
		return infoCategoria;
	}
	
	public Categoria buscarPorNome(CategoriaDTO nome) {
		return categoriaRepository.findByNome(nome.getNome()).get();
	}

	public CategoriaDTO converterCategoriaDTO(Categoria categoria) {
		CategoriaDTO categoriaConvertida = new CategoriaDTO();
		categoriaConvertida.setNome(categoria.getNome());
		categoriaConvertida.setDescricao(categoria.getDescricao());
		return categoriaConvertida;
	}
	
	public List<CategoriaDTO> listarTodos() {
		List<CategoriaDTO> infoCategorias = new ArrayList<>();
		List<Categoria> categorias = categoriaRepository.findAll();
		for(Categoria categoria : categorias) {
			infoCategorias.add(converterCategoriaDTO(categoria));
		}
		return infoCategorias;
	}

	public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {
		Categoria salvarCategoria = new Categoria();
		salvarCategoria.setNome(categoriaDTO.getNome());
		salvarCategoria.setDescricao(categoriaDTO.getDescricao());
		categoriaRepository.save(salvarCategoria);
		CategoriaDTO categoriaConvertida = converterCategoriaDTO(salvarCategoria);
		
		return categoriaConvertida;
	}

	public void remover(Integer id) {
		categoriaRepository.deleteById(id);
	}
	
	public CategoriaDTO atualizar(Integer id, CategoriaDTO categoriaDTO) {
						
		Categoria registroAntigo = categoriaRepository.findById(id).get();

		if (categoriaDTO.getDescricao() != null) {
			registroAntigo.setDescricao(categoriaDTO.getDescricao());
		}
		if (categoriaDTO.getNome() != null) {
			registroAntigo.setNome(categoriaDTO.getNome());
		}
		CategoriaDTO categoriaConvertida = converterCategoriaDTO(registroAntigo);
		registroAntigo.setId(id);
		categoriaRepository.save(registroAntigo);
		return categoriaConvertida;
	}
	
}
