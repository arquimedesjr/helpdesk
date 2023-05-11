package br.com.arquivi.backend.helpdesk.domain.services;

import br.com.arquivi.backend.helpdesk.domain.models.Client;
import br.com.arquivi.backend.helpdesk.domain.models.Technician;

import java.util.List;

public interface HelpdeskService {

    Technician findByIdTechnician(Integer id);

    List<Technician> findAllTechnician();

    Integer createTechnician(Technician technician);

    Technician updateTechnician(Integer id, Technician technician);

    void deleteTechnician(Integer id);

    Client findByIdClient(Integer id);

    List<Client> findAllClient();
}
