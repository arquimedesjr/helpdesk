package br.com.arquivi.backend.helpdesk.infrastructure.epositories;

import br.com.arquivi.backend.helpdesk.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
