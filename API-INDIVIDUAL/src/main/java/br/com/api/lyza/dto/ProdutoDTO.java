package br.com.api.lyza.dto;

import java.time.LocalDate;

public class ProdutoDTO {
	
	private String nome;
	private String descricao;
	private LocalDate dataFab;
	private Integer qtdEstoque;
	private Double valorUnit;
	private CategoriaDTO categoriaDTO;
	private VendedorDTO2 vendedorDTO2;

	public ProdutoDTO(String nome, String descricao, LocalDate dataFab, Integer qtdEstoque, Double valorUnit,
			CategoriaDTO categoriaDTO, VendedorDTO2 vendedorDTO2) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataFab = dataFab;
		this.qtdEstoque = qtdEstoque;
		this.valorUnit = valorUnit;
		this.categoriaDTO = categoriaDTO;
		this.vendedorDTO2 = vendedorDTO2;
	}

	public ProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public VendedorDTO2 getVendedorDTO2() {
		return vendedorDTO2;
	}

	public void setVendedorDTO2(VendedorDTO2 vendedorDTO2) {
		this.vendedorDTO2 = vendedorDTO2;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataFab() {
		return dataFab;
	}

	public void setDataFab(LocalDate dataFab) {
		this.dataFab = dataFab;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}
		
}
