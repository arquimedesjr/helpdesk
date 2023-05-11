package br.com.arquivi.backend.helpdesk.domain.models;

import br.com.arquivi.backend.helpdesk.application.dtos.requests.CalledRequest;
import br.com.arquivi.backend.helpdesk.domain.enums.Priority;
import br.com.arquivi.backend.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Called implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOpen;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateClosed;

    private Priority priority;
    private Status status;
    private String title;
    private String observation;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "client_id")
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

    public Called(CalledRequest request, Integer clientId, Integer technicianId) {
        this.priority = Priority.toEnum(request.getPriority());
        this.status = Status.toEnum(request.getStatus());
        this.title = request.getTitle();
        this.observation = request.getObservation();
        this.client = new Client(clientId);
        this.technician = new Technician(technicianId);
    }

    public void verifyStatus() {
        if (this.status == Status.CLOSED) this.setDateClosed(LocalDate.now());
        else if (this.status == Status.OPEN) this.setDateOpen(LocalDate.now());
    }
}
