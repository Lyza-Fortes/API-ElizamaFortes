package br.com.api.lyza.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tb_user")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Integer id;

    @NotNull(message = "Campo nome de funcionário não pode ser nulo")
    @Column(name = "nome_completo")
    private String nomeCompleto;
    
    @Email
    @NotNull(message = "Campo e-mail não pode ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Column(name = "email_user")
    private String email;
    
    @CPF
    @Size(max = 14)
    @NotNull(message = "Campo CPF não pode ser nulo")
    @Column(name = "cpf_user")
    private String cpf;
    
    @NotNull(message = "Campo data de nascimento não pode ser nulo")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4}-\\d{4}")
    @Column(name = "telefone_user")
    private String telefone;
    
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}")
    @Column(name = "celular_user")
    private String celular;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Campo senha não pode ser nulo")
    @Column(name = "password_funcionario")
    private String password;
    
    @Column(name = "ativo_user")
    private Boolean ativo = true;
    
    @ManyToMany
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public User(Integer id, @NotNull(message = "Campo nome de funcionário não pode ser nulo") String nomeCompleto,
			@Email @NotNull(message = "Campo e-mail não pode ser nulo") @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String email,
			@CPF @Size(max = 14) @NotNull(message = "Campo CPF não pode ser nulo") String cpf,
			@NotNull(message = "Campo data de nascimento não pode ser nulo") LocalDate dataNascimento,
			@Pattern(regexp = "\\(\\d{2}\\) \\d{4}-\\d{4}") String telefone,
			@Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}") String celular,
			@NotNull(message = "Campo senha não pode ser nulo") String password, Boolean ativo, Set<Role> roles) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.password = password;
		this.ativo = ativo;
		this.roles = roles;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nomeCompleto=" + nomeCompleto + ", email=" + email + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", celular=" + celular
				+ ", password=" + password + ", ativo=" + ativo + ", roles=" + roles + "]";
	}


}