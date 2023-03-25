package br.com.arquivi.backend.helpdesck.infrastructure.epositories;

import br.com.arquivi.backend.helpdesck.domain.models.Client;
import br.com.arquivi.backend.helpdesck.domain.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
