package br.com.arquivi.backend.helpdesk.domain.models;

import br.com.arquivi.backend.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;

    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String mail;
    protected String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Profiles")
    protected Set<Integer> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dateCreated = LocalDate.now();

    public Person() {
        this.addProfile(Profile.CLIENT);
    }

    public Person(Integer id, String name, String cpf, String mail, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.mail = mail;
        this.password = password;
        this.addProfile(Profile.CLIENT);
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }

    public Boolean existCpf(String cpf, Integer id) {
        return this.cpf != null && this.cpf.equals(cpf) && this.id.equals(id);
    }

    public Boolean existMail(String mail, Integer id) {
        return this.mail != null && this.mail.equals(mail) && this.id.equals(id);
    }

}
