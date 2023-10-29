package br.com.api.lyza.dto;

import java.time.LocalDate;
import java.util.Set;

public class UserDTO {

    private String nomeCompleto;
	private String nomeUsuario;
    private String email;
    private String password;
    private String cpf;
    private LocalDate dataNascimento;
	private String telefoneFixo;
	private String celular;
	private Set<String> roles;
	
    private String cep;
	private String numero;
	private String complementoAdicional;
	

	public UserDTO() {
	}

	public UserDTO(String nomeCompleto, String email, String password, String telefoneFixo, String celular, String cpf,
			String cep, String numero, String complementoAdicional, Set<String> roles, LocalDate dataNascimento, String nomeUsuario) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.password = password;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.cpf = cpf;
		this.cep = cep;
		this.numero = numero;
		this.complementoAdicional = complementoAdicional;
		this.roles = roles;
		this.dataNascimento = dataNascimento;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplementoAdicional() {
		return complementoAdicional;
	}

	public void setComplementoAdicional(String complementoAdicional) {
		this.complementoAdicional = complementoAdicional;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "UserDTO [nomeCompleto=" + nomeCompleto + ", email=" + email + ", password=" + password
				+ ", telefoneFixo=" + telefoneFixo + ", celular=" + celular + ", cpf=" + cpf + ", cep=" + cep
				+ ", numero=" + numero + ", complementoAdicional=" + complementoAdicional + ", roles=" + roles
				+ ", dataNascimento=" + dataNascimento + "]";
	}

}