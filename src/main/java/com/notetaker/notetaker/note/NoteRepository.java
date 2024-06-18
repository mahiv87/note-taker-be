package com.notetaker.notetaker.note;

import com.notetaker.notetaker.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface NoteRepository extends JpaRepository<Note, Long> {
}
