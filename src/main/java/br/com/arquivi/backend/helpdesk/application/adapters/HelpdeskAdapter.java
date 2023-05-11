package br.com.arquivi.backend.helpdesk.application.adapters;

import br.com.arquivi.backend.helpdesk.application.dtos.responses.CalledResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.ClientResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.TechnicianResponse;
import br.com.arquivi.backend.helpdesk.domain.models.Called;
import br.com.arquivi.backend.helpdesk.domain.models.Client;
import br.com.arquivi.backend.helpdesk.domain.models.Technician;

import java.util.List;
import java.util.stream.Collectors;

public class HelpdeskAdapter {

    public static TechnicianResponse toTechnicianResponse(Technician technician) {
        return TechnicianResponse.builder()
                .id(technician.getId())
                .name(technician.getName())
                .cpf(technician.getCpf())
                .mail(technician.getMail())
                .password(technician.getPassword())
                .profiles(technician.getProfiles())
                .dateCreated(technician.getDateCreated()).build();
    }

    public static List<TechnicianResponse> toListTechnicianResponse(List<Technician> technicians) {
        return technicians.stream().map(x ->
                TechnicianResponse.builder()
                        .id(x.getId())
                        .name(x.getName())
                        .cpf(x.getCpf())
                        .mail(x.getMail())
                        .password(x.getPassword())
                        .profiles(x.getProfiles())
                        .dateCreated(x.getDateCreated())
                        .build()).collect(Collectors.toList());
    }

    public static ClientResponse toClientResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .cpf(client.getCpf())
                .mail(client.getMail())
                .password(client.getPassword())
                .profiles(client.getProfiles())
                .dateCreated(client.getDateCreated()).build();
    }

    public static List<ClientResponse> toListClientResponse(List<Client> clients) {
        return clients.stream().map(x ->
                ClientResponse.builder()
                        .id(x.getId())
                        .name(x.getName())
                        .cpf(x.getCpf())
                        .mail(x.getMail())
                        .password(x.getPassword())
                        .profiles(x.getProfiles())
                        .dateCreated(x.getDateCreated())
                        .build()).collect(Collectors.toList());
    }

    public static CalledResponse toCalledResponse(Called called) {
        return CalledResponse.builder()
                .id(called.getId())
                .observation(called.getObservation())
                .priority(called.getPriority())
                .status(called.getStatus())
                .title(called.getTitle())
                .technician(called.getTechnician())
                .client(called.getClient())
                .dateOpen(called.getDateOpen())
                .dateClosed(called.getDateClosed())
                .build();
    }

    public static List<CalledResponse> toListCalledResponse(List<Called> called) {
        return called.stream().map(x -> CalledResponse.builder()
                        .id(x.getId())
                        .observation(x.getObservation())
                        .priority(x.getPriority())
                        .status(x.getStatus())
                        .title(x.getTitle())
                        .technician(x.getTechnician())
                        .client(x.getClient())
                        .dateOpen(x.getDateOpen())
                        .dateClosed(x.getDateClosed())
                        .build()).collect(Collectors.toList());
    }
}
