package Curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"Curso.Models"})
@ComponentScan(basePackages = {"Curso.*"})
@EnableJpaRepositories(basePackages = {"Curso.Repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class MeuApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MeuApplication.class, args);
	}

//
//	/*mapenamento global que refete em todo sistema */
////	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//
//		registry.addMapping("/usuario/**")
//				.allowedMethods("POST")
//				.allowedOrigins("ww.cliente40.com.br"); /*liberando apenas requisições post para o usuario do servidor 40*/
//	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/usuario/**")
				.allowedMethods("*")
				.allowedOrigins("*");
		/* liberando mapeamento de usuario para todas as origens*/
	}
}
