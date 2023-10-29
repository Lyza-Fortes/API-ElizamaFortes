package br.com.api.lyza.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.lyza.config.JWTUtil;
import br.com.api.lyza.dto.LoginDTO;
import br.com.api.lyza.dto.UserDTO;
import br.com.api.lyza.entities.Cliente;
import br.com.api.lyza.entities.Endereco;
import br.com.api.lyza.entities.Role;
import br.com.api.lyza.entities.User;
import br.com.api.lyza.entities.Vendedor;
import br.com.api.lyza.enums.TipoRoleEnum;
import br.com.api.lyza.repositories.ClienteRepository;
import br.com.api.lyza.repositories.EnderecoRepository;
import br.com.api.lyza.repositories.RoleRepository;
import br.com.api.lyza.repositories.UserRepository;
import br.com.api.lyza.repositories.VendedorRepository;
import br.com.api.lyza.services.ClienteService;
import br.com.api.lyza.services.EnderecoService;
import br.com.api.lyza.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	UserService userService;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClienteService clienteService;

	@Autowired
	VendedorRepository vendedorRepository;

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoService enderecoService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/registro")
	public ResponseEntity<String> cadastro(@RequestParam String email, @Valid @RequestBody UserDTO user) {

		Set<String> strRoles = user.getRoles();
		Set<Role> roles = new HashSet<>();

		Endereco viaCep = enderecoService.pesquisarEndereco(user.getCep());
		Endereco enderecoNovo = new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(user.getCep());
		enderecoNovo.setComplemento(user.getComplementoAdicional());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setNumero(user.getNumero());
		enderecoNovo.setUf(viaCep.getUf());
		enderecoRepository.save(enderecoNovo);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(enderecoNovo);
		
		User usuarioResumido = new User();
		usuarioResumido.setEmail(user.getEmail());
		usuarioResumido.setRoles(roles);
		usuarioResumido.setCpf(user.getCpf());
		usuarioResumido.setDataNascimento(user.getDataNascimento());
		usuarioResumido.setTelefone(user.getTelefoneFixo());
		usuarioResumido.setCelular(user.getCelular());
		usuarioResumido.setNomeCompleto(user.getNomeCompleto());
		usuarioResumido.setNomeUsuario(user.getNomeUsuario());
		String encodedPass = passwordEncoder.encode(user.getPassword());
		usuarioResumido.setPassword(encodedPass);
		userService.save(usuarioResumido);
		User userNovo = userService.save(usuarioResumido);
		
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(TipoRoleEnum.ROLE_CLIENTE)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "VENDEDOR":
					Role adminRole = roleRepository.findByName(TipoRoleEnum.ROLE_VENDEDOR)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(adminRole);
					Vendedor vendedor = new Vendedor();
					vendedor.setUser(userRepository.findById(userNovo.getId()).get());
					vendedorRepository.save(vendedor);
					break;
				case "CLIENTE":
					Role userRole = roleRepository.findByName(TipoRoleEnum.ROLE_CLIENTE)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(userRole);
					Cliente cliente = new Cliente();
					cliente.setUser(userRepository.findById(userNovo.getId()).get());
					cliente.setEndereco(enderecoNovo);
					clienteRepository.save(cliente);
					break;
				}
			});
		}

		return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro efetuado com sucesso!");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO body) {
		try {
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					body.getEmail(), body.getPassword());

			authManager.authenticate(authInputToken);

			User user = userService.findByEmail(body.getEmail());
			User usuarioResumido = new User();

			usuarioResumido.setCelular(user.getCelular());
			usuarioResumido.setCpf(user.getCpf());
			usuarioResumido.setDataNascimento(user.getDataNascimento());
			usuarioResumido.setId(user.getId());
			usuarioResumido.setNomeCompleto(user.getNomeCompleto());
			usuarioResumido.setEmail(user.getEmail());
			usuarioResumido.setRoles(user.getRoles());
			usuarioResumido.setPassword(user.getPassword());
			usuarioResumido.setNomeUsuario(user.getNomeUsuario());
			usuarioResumido.setTelefone(user.getTelefone());
			String token = jwtUtil.generateTokenWithUserData(usuarioResumido);

			return ResponseEntity.status(HttpStatus.OK).body("Login efetuado com sucesso!\n\nToken:"+token);
		} catch (AuthenticationException authExc) {
			throw new RuntimeException("Credenciais Invalidas");
		}
	}


}
