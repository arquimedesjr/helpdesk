package br.com.arquivi.backend.helpdesk.infrastructure.repositories;

import br.com.arquivi.backend.helpdesk.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
