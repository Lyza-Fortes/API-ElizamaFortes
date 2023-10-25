package br.com.api.lyza.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produto")
	private Integer id;
	
	@NotNull
	@Column(name="nome_produto")
	private String nome;
	
	@NotNull
	@Column(name="descricao_produto")
	private String descricao;
	
	@NotNull
	@Column(name="valor_unit")
	private String valorUnit;
	
	@NotNull
	@Column(name="qtd_estoque")
	private String qtdEstoque;

	public Produto(Integer id, @NotNull String nome, @NotNull String descricao, @NotNull String valorUnit,
			@NotNull String qtdEstoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valorUnit = valorUnit;
		this.qtdEstoque = qtdEstoque;
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(String valorUnit) {
		this.valorUnit = valorUnit;
	}

	public String getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(String qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valorUnit=" + valorUnit
				+ ", qtdEstoque=" + qtdEstoque + "]";
	}
	
	
	

}
