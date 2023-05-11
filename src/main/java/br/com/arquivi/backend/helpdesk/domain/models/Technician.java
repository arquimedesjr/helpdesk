package br.com.arquivi.backend.helpdesk.domain.models;

import br.com.arquivi.backend.helpdesk.application.dtos.requests.TechnicianRequest;
import br.com.arquivi.backend.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Technician extends Person {

    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Called> calleds = new LinkedList<>();

    public Technician() {
        addProfile(Profile.TECHNICIAN);
    }

    public Technician(Integer id) {
        this.id = id;
    }

    public Technician(TechnicianRequest request) {
        this.name = request.getName();
        this.cpf = request.getCpf();
        this.mail = request.getMail();
        this.password = request.getPassword();
        this.profiles = request.getProfiles();
        addProfile(Profile.TECHNICIAN);
    }

    public Technician(Integer id, String name, String cpf, String mail, String password) {
        super(id, name, cpf, mail, password);
        addProfile(Profile.TECHNICIAN);
    }
}
