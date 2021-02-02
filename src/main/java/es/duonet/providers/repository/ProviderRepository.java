package es.duonet.providers.repository;

import es.duonet.providers.entity.Provider;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface ProviderRepository extends CrudRepository<Provider, Integer> {

    Stream<Provider> findAllByIdClient(int idClient);
}
