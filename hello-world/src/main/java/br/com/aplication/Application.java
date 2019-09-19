package br.com.aplication;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;

import br.com.domain.Usuario;
import br.com.repositories.UsuarioRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Usuario u = new Usuario();
				u.setChave("usuario" + i);
				u.setSenha("password" + i);
				return u;
			}).map(v -> repository.save(v)).forEach(System.out::println);
		};
	}

}
