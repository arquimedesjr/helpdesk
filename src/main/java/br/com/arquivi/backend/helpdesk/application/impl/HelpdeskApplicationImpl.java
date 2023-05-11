package br.com.arquivi.backend.helpdesk.application.impl;

import br.com.arquivi.backend.helpdesk.application.HelpdeskApplication;
import br.com.arquivi.backend.helpdesk.application.adapters.HelpdeskAdapter;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.CalledRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.ClientRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.TechnicianRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.CalledResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.ClientResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.TechnicianResponse;
import br.com.arquivi.backend.helpdesk.domain.models.Called;
import br.com.arquivi.backend.helpdesk.domain.models.Client;
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
        return this.helpdeskService.createClient(new Client(request));
    }

    @Override
    public ClientResponse updateClient(Integer id, ClientRequest request) {
        var client = this.helpdeskService.updateClient(id, new Client(request));
        return HelpdeskAdapter.toClientResponse(client);
    }

    @Override
    public void deleteClient(Integer id) {
        this.helpdeskService.deleteClient(id);
    }

    @Override
    public CalledResponse findByIdCalled(Integer id) {
        var called = this.helpdeskService.findByIdCalled(id);
        return HelpdeskAdapter.toCalledResponse(called);
    }

    @Override
    public List<CalledResponse> findAllCalled() {
        var called = this.helpdeskService.findAllCalled();
        return HelpdeskAdapter.toListCalledResponse(called);
    }

    @Override
    public Integer createCalled(CalledRequest request) {
        return this.helpdeskService.createCalled(new Called(request, request.getClient(),request.getTechnician()));
    }

    @Override
    public CalledResponse updateCalled(Integer id, CalledRequest request) {
        var called = this.helpdeskService.updateCalled(id, new Called(request, request.getClient(),request.getTechnician()));;
        return HelpdeskAdapter.toCalledResponse(called);
    }


}
