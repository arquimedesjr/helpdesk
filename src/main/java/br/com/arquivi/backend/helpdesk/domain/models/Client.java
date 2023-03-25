package br.com.arquivi.backend.helpdesk.domain.models;

import br.com.arquivi.backend.helpdesk.domain.enums.Profile;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Client extends Person {

    @OneToMany(mappedBy = "client")
    private List<Called> calleds = new LinkedList<>();

    public Client() {
        addProfile(Profile.CLIENT);
    }

    public Client(Integer id, String name, String cpf, String mail, String password) {
        super(id, name, cpf, mail, password);
    }
}
