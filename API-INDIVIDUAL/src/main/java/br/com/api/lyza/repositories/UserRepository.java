package br.com.api.lyza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.lyza.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
