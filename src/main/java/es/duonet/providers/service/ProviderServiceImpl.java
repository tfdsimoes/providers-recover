package es.duonet.providers.service;

import es.duonet.providers.entity.Provider;
import es.duonet.providers.repository.ProviderRepository;
import es.duonet.providers.utils.FileProcessor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;

    private FileProcessor fileProcessor;

    public ProviderServiceImpl(ProviderRepository providerRepository, FileProcessor fileProcessor) {
        this.providerRepository = providerRepository;
        this.fileProcessor = fileProcessor;
    }

    /**
     * It will get the providers based on the client id and save the result into a file
     *
     * @param idClient Id Client to search in the providers
     *
     * @return Optional with the absolute path to the file
     */
    @Override
    @Transactional
    public Optional<String> saveToFileFilterByIdClient(int idClient) {
        Supplier<Stream<Provider>> providers = () -> providerRepository.findAllByIdClient(idClient);

        if (providers.get().count() > 0) {
            return Optional.of(fileProcessor.saveProvidersToFile(providers.get()));
        } else {
            return Optional.empty();
        }
    }
}
