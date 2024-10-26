package pe.edu.upc.managewise.issue_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IssuePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssuePlatformApplication.class, args);
	}

}
