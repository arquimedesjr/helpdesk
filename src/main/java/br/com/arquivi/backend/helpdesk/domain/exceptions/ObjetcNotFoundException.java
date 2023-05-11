package br.com.arquivi.backend.helpdesk.domain.exceptions;

public class ObjetcNotFoundException extends RuntimeException {
    public ObjetcNotFoundException(String message) {
        super(message);
    }

    public ObjetcNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
