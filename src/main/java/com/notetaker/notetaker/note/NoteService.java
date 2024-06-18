package com.notetaker.notetaker.note;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> findAll() {
        return repository.findAll();
    }

    public Optional<Note> find(Long id) {
        return repository.findById(id);
    }

    public Note create(Note note) {
        return repository.save(note);
    }

    public Optional<Note> update(Long id, Note newNote) {
        return repository.findById(id)
                .map(oldNote -> {
                    Note updated = oldNote.updateWith(newNote);
                    return repository.save(updated);
                });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

