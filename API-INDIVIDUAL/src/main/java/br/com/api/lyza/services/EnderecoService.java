package br.com.api.lyza.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.api.lyza.entities.Endereco;

@Service
public class EnderecoService {
	public Endereco pesquisarEndereco(String cep) { //pesquisa o endreço através do CEP
		RestTemplate restTemplate = new RestTemplate(); //Cria uma nova instancia e faz uma requisição
		String uri = "http://viacep.com.br/ws/{cep}/json/"; //API da requisição das informações
		Map<String, String> params = new HashMap<>(); //faz um hashmap onde recebe dois valores string
		params.put("cep", cep); //o primeiro CEP é a chave e o segundo é a variável que será passada no parâmentro (linha 62)
		return restTemplate.getForObject(uri, Endereco.class, params); //Pega a URI, entende que o CEP vai ser preenchido com os params e retorna as informações do CEP
	}
	
}
