package br.com.arquivi.backend.helpdesk.application.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorResponse extends StandarErrorResponse {

    private List<FieldMessageResponse> errors = new LinkedList<>();

    public ValidationErrorResponse(LocalDateTime timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void setErrors(String fieldName, String message) {
        this.errors.add(FieldMessageResponse.builder().fieldName(fieldName).message(message).build());
    }

}
