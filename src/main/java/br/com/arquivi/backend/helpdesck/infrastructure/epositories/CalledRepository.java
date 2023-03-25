package br.com.arquivi.backend.helpdesck.infrastructure.epositories;

import br.com.arquivi.backend.helpdesck.domain.models.Called;
import br.com.arquivi.backend.helpdesck.domain.models.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalledRepository extends JpaRepository<Called, Integer> {
}
