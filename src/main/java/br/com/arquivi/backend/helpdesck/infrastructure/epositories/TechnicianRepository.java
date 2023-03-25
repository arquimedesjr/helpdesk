package br.com.arquivi.backend.helpdesck.infrastructure.epositories;

import br.com.arquivi.backend.helpdesck.domain.models.Person;
import br.com.arquivi.backend.helpdesck.domain.models.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
}
