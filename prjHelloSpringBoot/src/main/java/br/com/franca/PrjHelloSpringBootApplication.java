package br.com.franca;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import br.com.franca.domain.Usuario;
import br.com.franca.repositories.UsuarioRepository;

@SpringBootApplication
public class PrjHelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjHelloSpringBootApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Usuario u = new Usuario();
				u.setChave("user" + i);
				u.setSenha("password" + i);
				return u;
			}).map(v -> repository.save(v)).forEach(System.out::println);
		};
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {

	    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	    source.setBasenames("mesagens"); 
	    // source.setUseCodeAsDefaultMessage(true);

	    return source;
	}

}
