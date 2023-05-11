package br.com.arquivi.backend.helpdesk.api;

import br.com.arquivi.backend.helpdesk.application.HelpdeskApplication;
import br.com.arquivi.backend.helpdesk.application.dtos.requests.CalledRequest;
import br.com.arquivi.backend.helpdesk.application.dtos.responses.CalledResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/called")
@RequiredArgsConstructor
public class CalledController {

    private final HelpdeskApplication application;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CalledResponse> findById(@PathVariable Integer id) {
        var called = this.application.findByIdCalled(id);
        return ResponseEntity.ok(called);
    }

    @GetMapping
    public ResponseEntity<List<CalledResponse>> findAll() {
        var called = this.application.findAllCalled();
        return ResponseEntity.ok(called);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CalledRequest request) {
        var id = this.application.createCalled(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<TechnicianResponse> update(@PathVariable Integer id, @Valid @RequestBody TechnicianRequest request) {
//        var technicianResponse = this.application.updateTechnician(id, request);
//        return ResponseEntity.ok(technicianResponse);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        this.application.deleteTechnician(id);
//        return ResponseEntity.noContent().build();
//    }
}