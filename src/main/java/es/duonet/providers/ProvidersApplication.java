package es.duonet.providers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvidersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProvidersApplication.class, args);
	}

	@Override
	public void run(String... args) {
		int idClient = ArgsProcessor.getIdClient(args);
	}
}
