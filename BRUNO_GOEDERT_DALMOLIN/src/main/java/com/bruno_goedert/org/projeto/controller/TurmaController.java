package com.bruno_goedert.org.projeto.controller;

import com.bruno_goedert.org.projeto.dto.TurmaRequest;
import com.bruno_goedert.org.projeto.dto.TurmaResponse;
import com.bruno_goedert.org.projeto.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    // C - CREATE
    @PostMapping
    public ResponseEntity<TurmaResponse> create(@Valid @RequestBody TurmaRequest body) {
        TurmaResponse created = service.create(body);
        return ResponseEntity
                .created(URI.create("/turmas/" + created.getId()))
                .body(created);
    }

    // R - READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // R - READ all
    @GetMapping
    public ResponseEntity<List<TurmaResponse>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    // U - UPDATE by ID
    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponse> update(@PathVariable Long id,
                                                @Valid @RequestBody TurmaRequest body) {
        return ResponseEntity.ok(service.update(id, body));
    }

    // D - DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
