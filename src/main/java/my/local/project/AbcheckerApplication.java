package my.local.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AbcheckerApplication {

	public static void main(String[] args) {
//		ReactorDebugAgent.init();
		SpringApplication.run(AbcheckerApplication.class, args);
	}

}
