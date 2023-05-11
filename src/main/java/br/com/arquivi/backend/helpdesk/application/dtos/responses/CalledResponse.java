package br.com.arquivi.backend.helpdesk.application.dtos.responses;

import br.com.arquivi.backend.helpdesk.domain.enums.Priority;
import br.com.arquivi.backend.helpdesk.domain.enums.Status;
import br.com.arquivi.backend.helpdesk.domain.models.Client;
import br.com.arquivi.backend.helpdesk.domain.models.Technician;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalledResponse {

    private Integer id;
    private Priority priority;
    private Status status;
    private String title;
    private String observation;
    private Technician technician;
    private Client client;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOpen;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateClosed;
}
