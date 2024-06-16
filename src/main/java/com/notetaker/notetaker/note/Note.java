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
}
