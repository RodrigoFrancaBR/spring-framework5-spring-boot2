package br.com.franca.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.franca.domain.Usuario;
import br.com.franca.repositories.UsuarioRepository;
import br.com.franca.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	public List<Usuario> buscar() {

		// validações de negocios

		return repository.findAll();
	}

	public Usuario buscar(Integer id) throws ObjectNotFoundException {
		// validações de negocios		
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo:" + Usuario.class.getName()));
	}

	public Usuario salvar(Usuario usuario) {
		// usuario.setId(null);
		return repository.save(usuario);
		 
	}

	public Usuario alterar(Usuario usuario) throws ObjectNotFoundException {
		buscar(usuario.getId());
		return repository.save(usuario);		
	}
}
