package br.com.arquivi.backend.helpdesk.application.dtos.responses;

import br.com.arquivi.backend.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponse {

    private Integer id;
    private String name;
    private String cpf;
    private String mail;
    private String password;
    private Set<Profile> profiles;
    private LocalDate dateCreated;
}
