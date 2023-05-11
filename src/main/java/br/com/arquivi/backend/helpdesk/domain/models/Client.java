package br.com.arquivi.backend.helpdesk.domain.models;

import br.com.arquivi.backend.helpdesk.application.dtos.requests.ClientRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.TechnicianRequest;
import br.com.arquivi.backend.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Called> calleds = new LinkedList<>();

    public Client() {
        addProfile(Profile.CLIENT);
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(ClientRequest request) {
        this.name = request.getName();
        this.cpf = request.getCpf();
        this.mail = request.getMail();
        this.password = request.getPassword();
        this.profiles = request.getProfiles();
        addProfile(Profile.CLIENT);
    }

    public Client(Integer id, String name, String cpf, String mail, String password) {
        super(id, name, cpf, mail, password);
        addProfile(Profile.CLIENT);
    }
}
