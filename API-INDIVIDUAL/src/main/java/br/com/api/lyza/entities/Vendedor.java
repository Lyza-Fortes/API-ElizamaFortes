package br.com.api.lyza.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_vendedor")
public class Vendedor {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vendedor")
	private Integer id;
	
	@NotNull
	@Column(name="cpf_vendedor")
	private String cpf;
	
	@NotNull
	@Column(name="nome_vendedor")
	private String nome;
	
	@NotNull
	@Column(name="setor_vendedor")
	private String setor;

	public Vendedor(Integer id, @NotNull String cpf, @NotNull String nome, @NotNull String setor) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.setor = setor;
	}

	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", setor=" + setor + "]";
	}
	
}
