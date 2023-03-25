package br.com.arquivi.backend.helpdesk.infrastructure.epositories;

import br.com.arquivi.backend.helpdesk.domain.models.Called;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalledRepository extends JpaRepository<Called, Integer> {
}
