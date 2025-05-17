package pe.edu.upc.managewise.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "pe.edu.upc.managewise.backend")
@EnableJpaRepositories(basePackages = "pe.edu.upc.managewise.backend")
@EnableJpaAuditing
public class ManagewiseBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagewiseBackendApplication.class, args);
	}

}
