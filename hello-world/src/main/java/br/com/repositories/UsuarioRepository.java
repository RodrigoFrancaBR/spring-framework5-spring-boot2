package br.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
