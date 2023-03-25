package br.com.arquivi.backend.helpdesk.infrastructure.epositories;

import br.com.arquivi.backend.helpdesk.domain.models.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
}
