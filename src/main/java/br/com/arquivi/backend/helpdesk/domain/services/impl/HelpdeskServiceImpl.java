package br.com.arquivi.backend.helpdesk.domain.services.impl;

import br.com.arquivi.backend.helpdesk.domain.exceptions.DataIntegrityViolationException;
import br.com.arquivi.backend.helpdesk.domain.exceptions.ObjetcNotFoundException;
import br.com.arquivi.backend.helpdesk.domain.models.Called;
import br.com.arquivi.backend.helpdesk.domain.models.Client;
import br.com.arquivi.backend.helpdesk.domain.models.Technician;
import br.com.arquivi.backend.helpdesk.domain.services.HelpdeskService;
import br.com.arquivi.backend.helpdesk.infrastructure.repositories.CalledRepository;
import br.com.arquivi.backend.helpdesk.infrastructure.repositories.ClientRepository;
import br.com.arquivi.backend.helpdesk.infrastructure.repositories.PersonRepository;
import br.com.arquivi.backend.helpdesk.infrastructure.repositories.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpdeskServiceImpl implements HelpdeskService {

    private final TechnicianRepository technicianRepository;
    private final ClientRepository clientRepository;
    private final PersonRepository personRepository;
    private final CalledRepository calledRepository;

    @Override
    public Technician findByIdTechnician(Integer id) {
        var technicianOptional = this.technicianRepository.findById(id);
        if (technicianOptional.isEmpty()) throw new ObjetcNotFoundException("Technician not found! Id: " + id);
        return technicianOptional.get();
    }

    @Override
    public List<Technician> findAllTechnician() {
        var technicians = this.technicianRepository.findAll();
        if (technicians.isEmpty()) throw new ObjetcNotFoundException("Technician not found!");
        return technicians;
    }

    @Override
    public Integer createTechnician(Technician technician) {
        var personRepositoryByCpf = this.personRepository.findByCpf(technician.getCpf());
        if (personRepositoryByCpf.isPresent()) {
            var existCpf = personRepositoryByCpf.get().existCpf(technician.getCpf(), null);
            if (existCpf) throw new DataIntegrityViolationException("CPF registered in the system!");

            var personRepositoryByMail = this.personRepository.findByMail(technician.getMail());
            if (personRepositoryByMail.isPresent()) {
                var existMail = personRepositoryByMail.get().existMail(technician.getMail(), null);
                if (existMail) throw new DataIntegrityViolationException("Mail registered in the system!");
            }
        }

        var newTechnician = this.technicianRepository.save(technician);
        return newTechnician.getId();
    }

    @Override
    public Technician updateTechnician(Integer id, Technician technician) {
        var oldTechnician = this.findByIdTechnician(id);
        if (oldTechnician != null) {
            var personRepositoryByCpf = this.personRepository.findByCpf(technician.getCpf());
            if (personRepositoryByCpf.isPresent()) {
                var existCpf = personRepositoryByCpf.get().existCpf(technician.getCpf(), id);
                if (!existCpf) throw new DataIntegrityViolationException("CPF registered in the system!");
            }

            var personRepositoryByMail = this.personRepository.findByMail(technician.getMail());
            if (personRepositoryByMail.isPresent()) {
                var existMail = personRepositoryByMail.get().existMail(technician.getMail(), id);
                if (!existMail) throw new DataIntegrityViolationException("Mail registered in the system!");
            }
        }
        technician.setId(id);
        return this.technicianRepository.save(technician);
    }

    @Override
    public void deleteTechnician(Integer id) {
        var technician = this.findByIdTechnician(id);
        if (technician.getCalleds().size() > 0)
            throw new DataIntegrityViolationException("Technician has service order and cannot be deleted!");
        this.technicianRepository.deleteById(id);
    }

    @Override
    public Client findByIdClient(Integer id) {
        var clientOptional = this.clientRepository.findById(id);
        if (clientOptional.isEmpty()) throw new ObjetcNotFoundException("Client not found! Id: " + id);
        return clientOptional.get();
    }

    @Override
    public List<Client> findAllClient() {
        var clients = this.clientRepository.findAll();
        if (clients.isEmpty()) throw new ObjetcNotFoundException("Client not found!");
        return clients;
    }

    @Override
    public Integer createClient(Client client) {
        var personRepositoryByCpf = this.personRepository.findByCpf(client.getCpf());
        if (personRepositoryByCpf.isPresent()) {
            var existCpf = personRepositoryByCpf.get().existCpf(client.getCpf(), null);
            if (existCpf) throw new DataIntegrityViolationException("CPF registered in the system!");

            var personRepositoryByMail = this.personRepository.findByMail(client.getMail());
            if (personRepositoryByMail.isPresent()) {
                var existMail = personRepositoryByMail.get().existMail(client.getMail(), null);
                if (existMail) throw new DataIntegrityViolationException("Mail registered in the system!");
            }
        }
        var newClient = this.clientRepository.save(client);
        return newClient.getId();
    }

    @Override
    public Client updateClient(Integer id, Client client) {
        var oldClient = this.findByIdClient(id);
        if (oldClient != null) {
            var personRepositoryByCpf = this.personRepository.findByCpf(client.getCpf());
            if (personRepositoryByCpf.isPresent()) {
                var existCpf = personRepositoryByCpf.get().existCpf(client.getCpf(), id);
                if (!existCpf) throw new DataIntegrityViolationException("CPF registered in the system!");
            }
            var personRepositoryByMail = this.personRepository.findByMail(client.getMail());
            if (personRepositoryByMail.isPresent()) {
                var existMail = personRepositoryByMail.get().existMail(client.getMail(), id);
                if (!existMail) throw new DataIntegrityViolationException("Mail registered in the system!");
            }
        }
        client.setId(id);
        return this.clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        var client = this.findByIdClient(id);
        if (client.getCalleds().size() > 0)
            throw new DataIntegrityViolationException("Client has service order and cannot be deleted!");
        this.clientRepository.deleteById(id);
    }

    @Override
    public Called findByIdCalled(Integer id) {
        var calledOptional = this.calledRepository.findById(id);
        if (calledOptional.isEmpty()) throw new ObjetcNotFoundException("Called not found! Id: " + id);
        return calledOptional.get();
    }

    @Override
    public List<Called> findAllCalled() {
        var called = this.calledRepository.findAll();
        if (called.isEmpty()) throw new ObjetcNotFoundException("Called not found!");
        return called;
    }

    @Override
    public Integer createCalled(Called called) {
        var client = this.findByIdClient(called.getClient().getId());
        var technician = this.findByIdTechnician(called.getTechnician().getId());

        called.setClient(client);
        called.setTechnician(technician);

        var newCalled = this.calledRepository.save(called);
        return newCalled.getId();
    }
}
