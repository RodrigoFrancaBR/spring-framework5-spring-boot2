package br.com.franca.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.franca.domain.Usuario;
import br.com.franca.service.UsuarioService;
import br.com.franca.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping({ "/usuarios" })
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public List<Usuario> buscar() {
		return this.service.buscar();
	}

	@GetMapping(value = { "/{id}" })
	public ResponseEntity<Usuario> buscar(@PathVariable Integer id) throws ObjectNotFoundException {
		Usuario usuario = service.buscar(id);
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody Usuario usuario) {
		Usuario resultado = service.salvar(usuario);
		// add o location http://localhost:8000/usuarios/1 no headers
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultado.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	//ObjectNotFoundException classe resp por gerar exception de not found
	public ResponseEntity<Void> alterar(@Valid @RequestBody Usuario usuario, @PathVariable Integer id)
			throws ObjectNotFoundException {
		service.alterar(usuario);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable Integer id) throws ObjectNotFoundException {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<Usuario>> buscarPorPagina(
			@RequestParam(value = "page", defaultValue = " 0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "chave") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Usuario> list = service.buscarPorPagina(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
