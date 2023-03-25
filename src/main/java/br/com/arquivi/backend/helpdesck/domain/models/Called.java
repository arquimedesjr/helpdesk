package br.com.arquivi.backend.helpdesck.domain.models;

import br.com.arquivi.backend.helpdesck.domain.enums.Priority;
import br.com.arquivi.backend.helpdesck.domain.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Called {

    private Integer id;
    private LocalDate dateOpen = LocalDate.now();
    private LocalDate dateClosed = LocalDate.now();
    private Priority priority;
    private Status status;
    private String title;
    private String observation;
    private Technician technician;
    private Client client;

    public Called(Integer id, Priority priority, Status status, String title, String observation, Technician technician, Client client) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.observation = observation;
        this.technician = technician;
        this.client = client;
    }
}
