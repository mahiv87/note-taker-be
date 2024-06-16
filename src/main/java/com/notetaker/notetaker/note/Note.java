package com.notetaker.notetaker.note;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;

public class Note {
    private final Long id;

    @NotNull(message = "title is required")
    private final String title;

    @NotNull(message = "text is required")
    private final String text;

    public Note(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Note updateWith(Note note) {
        return new Note(
                this.id,
                note.title,
                note.text
        );
    }
}
