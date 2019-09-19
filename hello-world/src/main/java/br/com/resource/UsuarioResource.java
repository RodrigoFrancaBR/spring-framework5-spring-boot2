package br.com.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping(path = { "/{id}" })
	ResponseEntity<?> buscar(@PathVariable Integer id) {
		return service.buscar(id);
	}

	/*
	 * public UsuarioResource(UsuarioRepository repository) { this.repository =
	 * repository; }
	 */
	/*
	 * @PostMapping public Usuario efetuarLogin(@RequestBody Usuario user) {
	 * System.out.println(user); return repository.save(user); }
	 * 
	 * @GetMapping public List<Usuario> findAll() { return repository.findAll(); }
	 * 
	 * @GetMapping(path = { "/{id}" }) public ResponseEntity<Usuario>
	 * findById(@PathVariable long id) { return repository.findById(id).map(record
	 * -> ResponseEntity.ok().body(record))
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * 
	 * @PostMapping public User create(@RequestBody User user) { return
	 * repository.save(user); }
	 * 
	 * 
	 * @PutMapping(value = "/{id}") public ResponseEntity<Usuario>
	 * update(@PathVariable("id") long id, @RequestBody Usuario user) { return
	 * repository.findById(id).map(record -> { record.setChave(user.getChave());
	 * record.setSenha(user.getSenha()); Usuario updated = repository.save(record);
	 * return ResponseEntity.ok().body(updated);
	 * }).orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @DeleteMapping(path = { "/{id}" }) public ResponseEntity<?>
	 * delete(@PathVariable long id) { return repository.findById(id).map(record ->
	 * { repository.deleteById(id); return ResponseEntity.ok().build();
	 * }).orElse(ResponseEntity.notFound().build()); }
	 */

}
