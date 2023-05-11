package br.com.arquivi.backend.helpdesk.api;

import br.com.arquivi.backend.helpdesk.application.HelpdeskApplication;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.ClientRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.ClientResponse;
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
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final HelpdeskApplication application;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable Integer id) {
        var technicianResponse = this.application.findByIdClient(id);
        return ResponseEntity.ok(technicianResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        var technicianResponse = this.application.findAllClient();
        return ResponseEntity.ok(technicianResponse);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ClientRequest request) {
        var id = this.application.createClient(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Integer id, @Valid @RequestBody ClientRequest request) {
        var technicianResponse = this.application.updateClient(id, request);
        return ResponseEntity.ok(technicianResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.application.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
