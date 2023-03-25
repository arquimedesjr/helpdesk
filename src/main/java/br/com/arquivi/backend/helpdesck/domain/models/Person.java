package br.com.arquivi.backend.helpdesck.domain.models;

import br.com.arquivi.backend.helpdesck.domain.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class Person {

    protected Integer id;
    protected String name;
    protected String cpf;
    protected String mail;
    protected String password;
    protected Set<Integer> profiles = new HashSet<>();
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
}
