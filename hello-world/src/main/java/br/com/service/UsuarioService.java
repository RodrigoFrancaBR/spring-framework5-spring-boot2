package br.com.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.domain.Usuario;
import br.com.repositories.UsuarioRepository;

// Anotação que serve para definir uma classe como pertencente à camada de Serviço da aplicação.
@Service
public class UsuarioService {

	
	private UsuarioRepository repository;

	
	  public UsuarioService(UsuarioRepository repository) { this.repository =
	  repository; }
	 

	public ResponseEntity<Usuario> buscar(Integer id) {
		/*
		 * Optional<Usuario> usuario = repository.findById(id); return
		 * usuario.orElse(null);
		 */
		
		return repository.findById(id).map(resultado-> ResponseEntity.ok().body(resultado)).orElse(ResponseEntity.notFound().build());		
	}

}
