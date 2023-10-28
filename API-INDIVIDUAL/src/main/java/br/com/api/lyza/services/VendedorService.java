package br.com.api.lyza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.lyza.dto.VendedorDTO;
import br.com.api.lyza.entities.Vendedor;
import br.com.api.lyza.repositories.EnderecoRepository;
import br.com.api.lyza.repositories.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	VendedorRepository vendedorRepository;

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	UserService userService;

	public VendedorDTO buscarPorId(Integer id) {
		VendedorDTO infoVendedor = new VendedorDTO();
		Vendedor vendedor = vendedorRepository.findById(id).get();
		infoVendedor = converterVendedorDTO(vendedor);
		return infoVendedor;
	}
	
	public VendedorDTO buscarFuncPorId(Integer id) {
		VendedorDTO infoVendedor = new VendedorDTO();
		Vendedor vendedor = vendedorRepository.findById(id).get();
		infoVendedor = converterVendedorDTO(vendedor);
		return infoVendedor;
	}

	public List<VendedorDTO> listarTodos() {
		List<VendedorDTO> infoVendedors = new ArrayList<>();
		List<Vendedor> vendedors = vendedorRepository.findAll();
		for (Vendedor vendedor : vendedors) {
			infoVendedors.add(converterVendedorDTO(vendedor));
		}
		return infoVendedors;
	}
	
	public VendedorDTO converterVendedorDTO(Vendedor vendedor) {
		VendedorDTO vendedorConvertido = new VendedorDTO();
		return vendedorConvertido;
	}

	public Vendedor salvar(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	public VendedorDTO atualizar(Integer id, VendedorDTO vendedorDTO) {
		Vendedor registroAntigo = vendedorRepository.findById(id).get();

		VendedorDTO vendedorConvertido = converterVendedorDTO(registroAntigo);
		registroAntigo.setId(id);
		vendedorRepository.save(registroAntigo);
		return vendedorConvertido;
	}

	public void removerLogico(Integer id) {
		Vendedor vendedor = vendedorRepository.findById(id).get();

		if (vendedor != null) {
			vendedor.setAtivo(false);
			vendedorRepository.save(vendedor);
		}
	}

	public void ativarLogico(Integer id) {
		Vendedor vendedor = vendedorRepository.findById(id).get();

		if (vendedor != null) {
			vendedor.setAtivo(true);
			vendedorRepository.save(vendedor);
		}
	}
	
}
