package com.notetaker.notetaker.note;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    @NotNull(message = "title is required")
    private String title;

    @Column(name = "text")
    @NotNull(message = "text is required")
    private String text;

    protected Note() {
    }

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

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text +
                '}';
    }
}
