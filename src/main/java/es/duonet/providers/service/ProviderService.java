package es.duonet.providers.service;

import java.util.Optional;

public interface ProviderService {

    /**
     * It will get the providers based on the client id and save the result into a file
     *
     * @param idClient Id Client to search in the providers
     *
     * @return Optional with the absolute path to the file
     */
    public Optional<String> saveToFileFilterByIdClient(int idClient);
}
