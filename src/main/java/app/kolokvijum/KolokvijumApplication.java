package app.kolokvijum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class KolokvijumApplication extends SpringBootServletInitializer {
	public static void main(String args[]) {
		SpringApplication.run(KolokvijumApplication.class, args);
		System.out.println("Radi");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(KolokvijumApplication.class);
	}
}
