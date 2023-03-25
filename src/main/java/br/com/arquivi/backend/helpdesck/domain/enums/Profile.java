package br.com.arquivi.backend.helpdesck.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Profile {

    ADMIN(0, "ROLE_ADMIN"),
    CLIENT(1, "ROLE_CLIENT"),
    TECHNICIAN(2, "ROLE_TECHNICIAN");

    private final Integer code;
    private final String description;

    public static Profile toEnum(Integer cod) {
        if (cod == null) return null;

        for(Profile x: Profile.values()){
            if(cod.equals(x.getCode())) return x;
        }

        throw new IllegalArgumentException("Profile invalid");
    }


}
