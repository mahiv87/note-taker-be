package com.notetaker.notetaker.note;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

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
    public ResponseEntity<Note> find(@PathVariable("id")Long id) {
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
}
