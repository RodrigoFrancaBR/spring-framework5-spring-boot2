package br.com.franca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

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

	public void remover(Integer id) throws ObjectNotFoundException {
		buscar(id);
		repository.deleteById(id);
	}

	public Page<Usuario> buscarPorPagina(Integer page, Integer LinesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, LinesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);

	}
}
