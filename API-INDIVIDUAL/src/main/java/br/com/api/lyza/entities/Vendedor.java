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
@Table(name="tb_vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vendedor")
	private Integer id;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Vendedor(Integer id, User user) {
		super();
		this.id = id;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", user=" + user + "]";
	}
	
	
	
}
