package br.com.franca.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.domain.Usuario;
import br.com.franca.service.UsuarioService;

@RestController
@RequestMapping({ "/usuarios" })
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public List<Usuario> buscar() {
		return this.service.buscar();
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(path = {"/{id}"})
	public ResponseEntity buscar(@PathVariable Integer id) {
		return service.buscar(id);
	}

}
