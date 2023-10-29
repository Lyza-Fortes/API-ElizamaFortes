package br.com.api.lyza.dto;

public class VendedorDTO2 {
	
	private String nomeCompleto;
	private String nomeUsuario;
	private String email;
	
	public VendedorDTO2() {
	}

	public VendedorDTO2(String nomeCompleto, String nomeUsuario, String email) {
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
	}

	public String getNome() {
		return nomeCompleto;
	}

	public void setNome(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
	