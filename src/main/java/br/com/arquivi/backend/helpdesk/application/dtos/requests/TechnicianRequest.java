package br.com.arquivi.backend.helpdesk.application.dtos.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TechnicianRequest {

    @NotNull(message = "Field name is required")
    private String name;
    @CPF(message = "Field cpf is invalid")
    @NotNull(message = "Field cpf is required")
    private String cpf;
    @NotNull(message = "Field mail is required")
    private String mail;
    @NotNull(message = "Field passoword is required")
    private String password;
    private Set<Integer> profiles;
}
