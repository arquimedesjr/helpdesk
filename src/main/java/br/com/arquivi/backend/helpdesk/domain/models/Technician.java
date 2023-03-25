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
public class Technician extends Person {

    @OneToMany(mappedBy = "technician")
    private List<Called> calleds = new LinkedList<>();

    public Technician() {
        addProfile(Profile.TECHNICIAN);
    }

    public Technician(Integer id, String name, String cpf, String mail, String password) {
        super(id, name, cpf, mail, password);
    }
}
