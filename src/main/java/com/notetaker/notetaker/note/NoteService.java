package com.notetaker.notetaker.note;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@EnableMapRepositories
public class NoteService {
    private final CrudRepository<Note, Long> repository;

    public NoteService(CrudRepository<Note, Long> repository) {
        this.repository = repository;
    }
}
