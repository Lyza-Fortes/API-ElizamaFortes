package br.com.api.lyza.enums;

public enum TipoRoleEnum {

	ROLE_CLIENTE("CLIENTE"),
	ROLE_VENDEDOR("VENDEDOR");

	private String tipo;

	TipoRoleEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}