package br.com.arquivi.backend.helpdesk.application.impl;

import br.com.arquivi.backend.helpdesk.application.HelpdeskApplication;
import br.com.arquivi.backend.helpdesk.application.adapters.HelpdeskAdapter;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.ClientRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.TechnicianRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.ClientResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.TechnicianResponse;
import br.com.arquivi.backend.helpdesk.domain.models.Technician;
import br.com.arquivi.backend.helpdesk.domain.services.HelpdeskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HelpdeskApplicationImpl implements HelpdeskApplication {

    private final HelpdeskService helpdeskService;

    @Override
    public TechnicianResponse findByIdTechnician(Integer id) {
        var technician = this.helpdeskService.findByIdTechnician(id);
        return HelpdeskAdapter.toTechnicianResponse(technician);
    }

    @Override
    public List<TechnicianResponse> findAllTechnician() {
        var technicians = this.helpdeskService.findAllTechnician();
        return HelpdeskAdapter.toListTechnicianResponse(technicians);
    }

    @Override
    public Integer createTechnician(TechnicianRequest request) {
        return this.helpdeskService.createTechnician(new Technician(request));
    }

    @Override
    public TechnicianResponse updateTechnician(Integer id, TechnicianRequest request) {
        this.helpdeskService.findByIdTechnician(id);
        var technician = this.helpdeskService.updateTechnician(id, new Technician(request));
        return HelpdeskAdapter.toTechnicianResponse(technician);
    }

    @Override
    public void deleteTechnician(Integer id) {
        this.helpdeskService.deleteTechnician(id);
    }

    @Override
    public ClientResponse findByIdClient(Integer id) {
        var client = this.helpdeskService.findByIdClient(id);
        return HelpdeskAdapter.toClientResponse(client);
    }

    @Override
    public List<ClientResponse> findAllClient() {
        var clients = this.helpdeskService.findAllClient();
        return HelpdeskAdapter.toListClientResponse(clients);
    }

    @Override
    public Integer createClient(ClientRequest request) {
        return null;
    }

    @Override
    public ClientResponse updateClient(Integer id, ClientRequest request) {
        return null;
    }

    @Override
    public void deleteClient(Integer id) {

    }


}
