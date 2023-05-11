package br.com.arquivi.backend.helpdesk.infrastructure.repositories;

import br.com.arquivi.backend.helpdesk.domain.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByMail(String mail);

    Optional<Person> findByCpf(String cpf);
}
