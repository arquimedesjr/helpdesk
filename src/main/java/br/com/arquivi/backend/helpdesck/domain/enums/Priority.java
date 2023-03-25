package br.com.arquivi.backend.helpdesck.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {

    LOW(0, "LOW"),
    AVERAGE(1, "AVERAGE"),
    HIGH(2, "HIGH");

    private final Integer code;
    private final String description;

    public static Priority toEnum(Integer cod) {
        if (cod == null) return null;

        for(Priority x: Priority.values()){
            if(cod.equals(x.getCode())) return x;
        }

        throw new IllegalArgumentException("Status invalid");
    }


}
