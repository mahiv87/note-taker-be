package com.notetaker.notetaker.note;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@EnableMapRepositories
public class NoteService {
    private final CrudRepository<Note, Long> repository;

    public NoteService(CrudRepository<Note, Long> repository) {
        this.repository = repository;
        this.repository.saveAll(defaultNotes());
    }

    private static List<Note> defaultNotes() {
        return List.of(
                new Note(1L, "Heroku", "heroku login\nheroku create\ngit push heroku main"),
                new Note(2L, "Java", "Practice writing Java more often")
        );
    }

    public List<Note> findAll() {
        List<Note> list = new ArrayList<>();
        Iterable<Note> notes = repository.findAll();
        notes.forEach(list::add);
        return list;
    }

    public Optional<Note> find(Long id) {
        return repository.findById(id);
    }

    public Note create(Note note) {
        Note copy = new Note(
                new Date().getTime(),
                note.getTitle(),
                note.getText()
        );
        return repository.save(copy);
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
