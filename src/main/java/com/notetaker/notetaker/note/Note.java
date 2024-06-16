package com.notetaker.notetaker.note;

public class Note {
    private final Long id;

    private final String title;

    private final String text;

    public Note(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

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
