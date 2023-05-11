package br.com.arquivi.backend.helpdesk.api.handler;

import br.com.arquivi.backend.helpdesk.application.dtos.responses.StandarErrorResponse;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.ValidationErrorResponse;
import br.com.arquivi.backend.helpdesk.domain.exceptions.DataIntegrityViolationException;
import br.com.arquivi.backend.helpdesk.domain.exceptions.ObjetcNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjetcNotFoundException.class)
    public ResponseEntity<StandarErrorResponse> objectNotFoundException(ObjetcNotFoundException exception, HttpServletRequest request) {

        StandarErrorResponse errorResponse = new StandarErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Object not found", exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandarErrorResponse> dataIntegrityViolationException(DataIntegrityViolationException exception, HttpServletRequest request) {

        StandarErrorResponse errorResponse = new StandarErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Data breach", exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandarErrorResponse> dataIntegrityViolationException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        ValidationErrorResponse validationError = new ValidationErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation error", "Field validation error", request.getRequestURI());

        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            validationError.setErrors(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}
