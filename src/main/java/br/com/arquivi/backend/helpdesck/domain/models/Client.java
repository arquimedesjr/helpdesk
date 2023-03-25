package br.com.arquivi.backend.helpdesck.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Client extends Person{

    private List<Called> calleds = new LinkedList<>();

    public Client(Integer id, String name, String cpf, String mail, String password) {
        super(id, name, cpf, mail, password);
    }
}
