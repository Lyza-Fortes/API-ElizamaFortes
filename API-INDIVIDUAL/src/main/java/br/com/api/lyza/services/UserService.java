package br.com.api.lyza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.lyza.entities.User;
import br.com.api.lyza.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> listarTodos() {
		return userRepository.findAll();
	}

//	public void remover(Integer id) {
//		User user = userRepository.findById(id).get();
//		emailService.envioEmailEncerramentoConta(user);
//		userRepository.deleteById(id);
//	}
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}

}
