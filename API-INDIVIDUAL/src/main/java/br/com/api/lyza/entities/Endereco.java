package br.com.api.lyza.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_endereço")
public class Endereco {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer id;

    @NotNull(message="Campo CEP não pode ser nulo")
    @Column(name="cep")
    private String cep;

    @NotNull(message="Campo logradouro não pode ser nulo")
    @Column(name="logradouro")
    private String logradouro;

    @NotNull(message="Campo número não pode ser nulo")
    @Column(name="numero")
    private String numero;

    @Column(name="complemento")
    private String complemento;

    @NotNull(message="Campo bairro não pode ser nulo")
    @Column(name="bairro")
    private String bairro;

    @NotNull(message="Campo localidade não pode ser nulo")
    @Column(name="localidade")
    private String localidade;

    @NotNull(message="Campo UF não pode ser nulo")
    @Column(name="uf")
    private String uf;

	public Endereco(Integer id, @NotNull(message = "Campo CEP não pode ser nulo") String cep,
			@NotNull(message = "Campo logradouro não pode ser nulo") String logradouro,
			@NotNull(message = "Campo número não pode ser nulo") String numero, String complemento,
			@NotNull(message = "Campo bairro não pode ser nulo") String bairro,
			@NotNull(message = "Campo localidade não pode ser nulo") String localidade,
			@NotNull(message = "Campo UF não pode ser nulo") String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf
				+ "]";
	}
    
}
