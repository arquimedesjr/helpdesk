package br.com.arquivi.backend.helpdesk.application;

import br.com.arquivi.backend.helpdesk.application.dtos.requests.CalledRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.ClientRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.TechnicianRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.CalledResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.ClientResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.TechnicianResponse;

import java.util.List;

public interface HelpdeskApplication {

    TechnicianResponse findByIdTechnician(Integer id);

    List<TechnicianResponse> findAllTechnician();

    Integer createTechnician(TechnicianRequest request);

    TechnicianResponse updateTechnician(Integer id, TechnicianRequest request);

    void deleteTechnician(Integer id);

    ClientResponse findByIdClient(Integer id);

    List<ClientResponse> findAllClient();

    Integer createClient(ClientRequest request);

    ClientResponse updateClient(Integer id, ClientRequest request);

    void deleteClient(Integer id);

    CalledResponse findByIdCalled(Integer id);

    List<CalledResponse> findAllCalled();

    Integer createCalled(CalledRequest request);

    CalledResponse updateCalled(Integer id, CalledRequest request);
}
