package br.com.franca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.franca.domain.Usuario;
import br.com.franca.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	public List<Usuario> buscar() {
		
		// validações de negocios
		
		return repository.findAll();
	}

	@SuppressWarnings("rawtypes")
	public ResponseEntity buscar(Integer id) {		
		
		// validações de negocios
		
		return repository.findById(id).map(resultado -> ResponseEntity.ok().body(resultado))
				.orElse(ResponseEntity.notFound().build());
	}

}
