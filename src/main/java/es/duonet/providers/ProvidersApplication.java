package es.duonet.providers;

import es.duonet.providers.service.ProviderService;
import es.duonet.providers.utils.ArgsProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class ProvidersApplication implements CommandLineRunner {

	private ProviderService providerService;

	public ProvidersApplication(ProviderService providerService) {
		this.providerService = providerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProvidersApplication.class, args);
	}

	@Override
	public void run(String... args) {
		int idClient = ArgsProcessor.getIdClient(args);
		Optional<String> absolutePath = providerService.saveToFileFilterByIdClient(idClient);

		if (absolutePath.isPresent()) {
			System.out.println("File is at: " + absolutePath.get());
		} else {
			System.out.println("There is no results");
		}
	}
}
