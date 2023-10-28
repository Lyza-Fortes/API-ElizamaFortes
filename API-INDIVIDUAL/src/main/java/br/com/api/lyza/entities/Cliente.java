package br.com.api.lyza.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@OneToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(Integer id, User user, Endereco endereco) {
		super();
		this.id = id;
		this.user = user;
		this.endereco = endereco;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", user=" + user + "]";
	}
	
	
}
