package br.com.franca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;

import br.com.franca.domain.Usuario;
import br.com.franca.repositories.UsuarioRepository;


@SpringBootApplication
public class PrjHelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjHelloSpringBootApplication.class, args);
	}
	
	/*
	 * @Bean CommandLineRunner init(UsuarioRepository repository) { return args -> {
	 * repository.deleteAll(); LongStream.range(1, 11).mapToObj(i -> { Usuario u =
	 * new Usuario(); u.setChave("user" + i); u.setSenha("password" + i); return u;
	 * }).map(v -> repository.save(v)).forEach(System.out::println); }; }
	 */


}
