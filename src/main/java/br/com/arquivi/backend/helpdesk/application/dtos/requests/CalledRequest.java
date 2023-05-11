package br.com.arquivi.backend.helpdesk.application.dtos.requests;

import br.com.arquivi.backend.helpdesk.domain.enums.Priority;
import br.com.arquivi.backend.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalledRequest {

    @NotNull(message = "Field priority is required")
    private Integer priority;
    @NotNull(message = "Field status is required")
    private Integer status;
    @NotNull(message = "Field title is required")
    private String title;
    @NotNull(message = "Field observation is required")
    private String observation;
    @NotNull(message = "Field technician is required")
    private Integer technician;
    @NotNull(message = "Field client is required")
    private Integer client;
}
