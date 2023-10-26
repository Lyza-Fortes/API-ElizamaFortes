package br.com.api.lyza.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

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
}
