package br.com.api.lyza.entities;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

}
