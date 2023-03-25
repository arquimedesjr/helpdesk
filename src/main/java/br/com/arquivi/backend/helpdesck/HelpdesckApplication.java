package br.com.arquivi.backend.helpdesck;

import br.com.arquivi.backend.helpdesck.domain.enums.Priority;
import br.com.arquivi.backend.helpdesck.domain.enums.Profile;
import br.com.arquivi.backend.helpdesck.domain.enums.Status;
import br.com.arquivi.backend.helpdesck.domain.models.Called;
import br.com.arquivi.backend.helpdesck.domain.models.Client;
import br.com.arquivi.backend.helpdesck.domain.models.Technician;
import br.com.arquivi.backend.helpdesck.infrastructure.epositories.CalledRepository;
import br.com.arquivi.backend.helpdesck.infrastructure.epositories.ClientRepository;
import br.com.arquivi.backend.helpdesck.infrastructure.epositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HelpdesckApplication implements CommandLineRunner {

	@Autowired
	private TechnicianRepository technicianRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CalledRepository calledRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdesckApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Technician t1 = new Technician(null, "Valdir Cezar", "96665314022", "test@gmail.com", "1234");
		t1.addProfile(Profile.ADMIN);

		Client c1 = new Client(null, "Linus", "29262825080", "client@gmail.com", "123");

		Called called1 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Chamado 1", "Primeiro chamado", t1, c1);

		technicianRepository.saveAll(List.of(t1));
		clientRepository.saveAll(List.of(c1));
		calledRepository.saveAll(List.of(called1));


	}
}
