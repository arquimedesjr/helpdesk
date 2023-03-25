package br.com.arquivi.backend.helpdesk.infrastructure.epositories;

import br.com.arquivi.backend.helpdesk.domain.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
