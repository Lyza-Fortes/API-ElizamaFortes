package br.com.api.lyza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.lyza.entities.User;
import br.com.api.lyza.entities.Vendedor;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<Vendedor> findByNomeCompleto(String nome);
	
	Optional<User> findByEmail(String email);

	@Query(value = "select * from tb_user where nome_usuario = :nomeUsuario", nativeQuery = true)
	User findByNomeUsuario(String nomeUsuario);
}
