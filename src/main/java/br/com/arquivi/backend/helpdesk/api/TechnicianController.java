package br.com.arquivi.backend.helpdesk.api;

import br.com.arquivi.backend.helpdesk.application.HelpdeskApplication;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.TechnicianRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.TechnicianResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/technician")
@RequiredArgsConstructor
public class TechnicianController {

    private final HelpdeskApplication application;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianResponse> findById(@PathVariable Integer id) {
        var technicianResponse = this.application.findByIdTechnician(id);
        return ResponseEntity.ok(technicianResponse);
    }

    @GetMapping
    public ResponseEntity<List<TechnicianResponse>> findAll() {
        var technicianResponse = this.application.findAllTechnician();
        return ResponseEntity.ok(technicianResponse);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody TechnicianRequest request) {
        var id = this.application.createTechnician(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TechnicianResponse> update(@PathVariable Integer id, @Valid @RequestBody TechnicianRequest request) {
        var technicianResponse = this.application.updateTechnician(id, request);
        return ResponseEntity.ok(technicianResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.application.deleteTechnician(id);
        return ResponseEntity.noContent().build();
    }
}