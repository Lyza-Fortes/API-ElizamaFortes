package br.com.api.lyza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.lyza.dto.ClienteDTO;
import br.com.api.lyza.entities.Cliente;
import br.com.api.lyza.repositories.ClienteRepository;
import br.com.api.lyza.repositories.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	UserService userService;
	
	public ClienteDTO buscarPorId(Integer id) {
		ClienteDTO infoCliente = new ClienteDTO();
		Cliente cliente = clienteRepository.findById(id).get();
		infoCliente = converterClienteDTO(cliente);
		return infoCliente;
	}

	public List<ClienteDTO> listarTodos() {
		List<ClienteDTO> infoClientes = new ArrayList<>();
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente cliente : clientes) {
			infoClientes.add(converterClienteDTO(cliente));
		}
		return infoClientes;
	}

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public ClienteDTO converterClienteDTO(Cliente cliente) {
		ClienteDTO clienteConvertido = new ClienteDTO();
		clienteConvertido.setBairro(cliente.getEndereco().getBairro());
		clienteConvertido.setCep(cliente.getEndereco().getCep());
		clienteConvertido.setComplemento(cliente.getEndereco().getComplemento());
		clienteConvertido.setLocalidade(cliente.getEndereco().getLocalidade());
		clienteConvertido.setLogradouro(cliente.getEndereco().getLogradouro());
		clienteConvertido.setNumero(cliente.getEndereco().getNumero());
		clienteConvertido.setUf(cliente.getEndereco().getUf());
		return clienteConvertido;
	}
	
	
	public ClienteDTO atualizar(Integer id, ClienteDTO clienteDTO) {
		Cliente registroAntigo = clienteRepository.findById(id).get();
		
		ClienteDTO clienteConvertido = converterClienteDTO(registroAntigo);
		registroAntigo.setId(id);
		clienteRepository.save(registroAntigo);
		return clienteConvertido;
	}

	public void remover(Integer id) {
		clienteRepository.deleteById(id);
	}

}
