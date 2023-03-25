package br.com.arquivi.backend.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    OPEN(0, "OPEN"),
    PROGRESS(1, "PROGRESS"),
    CLOSED(2, "CLOSED");

    private final Integer code;
    private final String description;

    public static Status toEnum(Integer cod) {
        if (cod == null) return null;

        for (Status x : Status.values()) {
            if (cod.equals(x.getCode())) return x;
        }

        throw new IllegalArgumentException("Status invalid");
    }


}
