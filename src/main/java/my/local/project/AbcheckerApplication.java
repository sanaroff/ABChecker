package my.local.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AbcheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcheckerApplication.class, args);

		/*SpringApplication app =new SpringApplication(AbcheckerApplication.class);
				app.setDefaultProperties(Collections
				.singletonMap("server.port", "8083"));
		app.run(args);*/
	}

}
