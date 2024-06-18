package com.notetaker.notetaker.note;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("api/notes")
public class NoteController {
    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        List<Note> notes = service.findAll();
        return ResponseEntity.ok().body(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> find(@PathVariable("id") Long id) {
        Optional<Note> note = service.find(id);
        return ResponseEntity.of(note);
    }

    @PostMapping
    public ResponseEntity<Note> create(@Valid @RequestBody Note note) {
        Note created = service.create(note);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable("id") Long id, @Valid @RequestBody Note updatedNote) {
        Optional<Note> updated = service.update(id, updatedNote);

        return updated
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> {
                    Note created = service.create(updatedNote);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(created.getId())
                            .toUri();
                    return ResponseEntity.created(location).body(created);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Note was successfully removed");
    }
}

