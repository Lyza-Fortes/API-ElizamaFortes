package br.com.api.lyza.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_pedido")
public class Pedido {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Integer id;

    @NotNull(message="Campo data de pedido não pode ser nulo")
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @ManyToMany
    @JoinTable(
            name="pedido_produto",
            joinColumns=@JoinColumn(name="pedido_id"),
            inverseJoinColumns=@JoinColumn(name="produto_id")
            )
    private List<Produto> produtos;


	@OneToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
    public Pedido() {
        super();
    }

	public Pedido(Integer id, @NotNull(message = "Campo data de pedido não pode ser nulo") LocalDateTime dataPedido,
			List<Produto> produtos, Cliente cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.produtos = produtos;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataPedido=" + dataPedido + ", produtos=" + produtos + ", cliente=" + cliente
				+ "]";
	}

  
}
